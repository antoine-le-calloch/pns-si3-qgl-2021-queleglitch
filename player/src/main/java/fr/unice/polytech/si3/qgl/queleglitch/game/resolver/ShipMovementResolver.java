package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class ShipMovementResolver {

    private final int NB_RAMES;
    private final int NB_VOILES;
    private final Ship ship;
    private final Wind wind;
    private final RegattaGoal regattaGoal;

    public ShipMovementResolver(Ship ship, Wind wind, RegattaGoal regattaGoal){
        this.ship = ship;
        this.wind = wind;
        this.regattaGoal = regattaGoal;
        NB_RAMES = ship.getOars().size();
        NB_VOILES = ship.getSails().size();
    }

    public Position resolveNextTurnPosition(double rudderAngle, SailAction actionOnSails, NbOarsUsed nbOarsUsed){
        final double NB_PART = 100;
        int nbHighSails = (actionOnSails == SailAction.DO_NOTHING && ship.getSails().get(0).isOpenned()) || (actionOnSails == SailAction.LIFT) ? NB_VOILES : 0;
        Position newPosition = new Position(ship.getPosition().getX(),ship.getPosition().getY(),ship.getPosition().getOrientation());
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
        return rudderAngle + ((nbOarsUsed.onRight() - nbOarsUsed.onLeft())*Math.PI/NB_RAMES);
    }


    //speed we are going to have using the elements given
    public double getSpeed(int nbHighSails, NbOarsUsed nbOarsUsed, double shipOrientation){
        double speedWithOars = 165.0*(nbOarsUsed.onLeft() + nbOarsUsed.onRight())/NB_RAMES;
        double speedWithWind = (1.0*nbHighSails/NB_VOILES)*wind.getStrength()*Math.cos(shipOrientation - wind.getOrientation());
        return speedWithOars + speedWithWind;
    }

    public Boolean isCheckpointPassed(Position checkpointPosition, double rudderAngle, SailAction actionOnSails, NbOarsUsed nbOarsUsed){
        Position nextTurnPosition = resolveNextTurnPosition(rudderAngle, actionOnSails, nbOarsUsed);
        Geometry geometry = new Geometry(nextTurnPosition);

        if(Math.abs(geometry.calculateAngleToCheckPoint(checkpointPosition)) > Math.PI/2)
            return regattaGoal.getActualCheckpoint().getPosition().getNorm(nextTurnPosition) > regattaGoal.getActualCheckpoint().getRadius();
        return false;
    }
}
