package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class ShipMovementResolver {

    private final RegattaGoal regattaGoal;
    private final int nbOars;
    private final int nbSails;
    private final Ship ship;
    private final Wind wind;

    public ShipMovementResolver(Ship ship, Wind wind, RegattaGoal regattaGoal){
        nbSails = ship.getNbSails();
        nbOars = ship.getNbOars();
        this.regattaGoal = regattaGoal;
        this.ship = ship;
        this.wind = wind;
    }

    public Position resolveNextTurnPosition(double rudderAngle, SailAction actionOnSails, NbOarsUsed nbOarsUsed){
        final double NB_PART = 100;
        int nbHighSails = (actionOnSails == SailAction.DO_NOTHING && ship.isSailsOpen()) || (actionOnSails == SailAction.LIFT) ? nbSails : 0;
        Position newPosition = ship.getPosition().copyOf();
        double anglePart = getAngleToTurn(rudderAngle, nbOarsUsed)/NB_PART;
        double speedPart;

        for (double i = 0; i < NB_PART; i++) {
            speedPart = getSpeed(nbHighSails, nbOarsUsed, newPosition.getOrientation())/NB_PART;
            newPosition = newPosition.calculateNewPosition(anglePart,speedPart);
        }
        return newPosition;
    }

    //angle we are going to turn using the elements given
    public double getAngleToTurn(double rudderAngle, NbOarsUsed nbOarsUsed){
        return rudderAngle + ((nbOarsUsed.onRight() - nbOarsUsed.onLeft())*Math.PI/ nbOars);
    }


    //speed we are going to have using the elements given
    public double getSpeed(int nbHighSails, NbOarsUsed nbOarsUsed, double shipOrientation){
        double speedWithOars = 165.0*(nbOarsUsed.onLeft() + nbOarsUsed.onRight())/ nbOars;
        double speedWithWind = (1.0*nbHighSails/ nbSails)*wind.getStrength()*Math.cos(shipOrientation - wind.getOrientation());
        return speedWithOars + speedWithWind;
    }

    public Boolean isPositionInCheckpoint(Position boatPosition){
        return regattaGoal.getActualCheckpoint().getPosition().getNorm(boatPosition) < regattaGoal.getActualCheckpoint().getRadius();
    }


    public Boolean isCheckpointMissed(Position checkpointPosition, double rudderAngle, SailAction actionOnSails, NbOarsUsed nbOarsUsed){
        Position nextTurnPosition = resolveNextTurnPosition(rudderAngle, actionOnSails, nbOarsUsed);
        Geometry geometry = new Geometry(nextTurnPosition);

        if(Math.abs(geometry.calculateAngleToCheckPoint(checkpointPosition)) > Math.PI/2){
            return !isPositionInCheckpoint(nextTurnPosition);
        }
        return false;
    }
}
