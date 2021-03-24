package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbRamesUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class ShipMovementResolver {

    final double NB_PART = 100.0;

    private final int NB_RAMES;
    private final int NB_VOILES;
    private final Ship ship;
    private final Wind wind;
    private final RegattaGoal regattaGoal;

    public ShipMovementResolver(Ship ship, Wind wind, RegattaGoal regattaGoal){
        this.ship = ship;
        this.wind = wind;
        this.regattaGoal = regattaGoal;
        NB_RAMES = ship.getRames().size();
        NB_VOILES = ship.getVoiles().size();
    }

    public Position resolveNextTurnPosition(double rudderAngle, VoileAction actionOnVoiles, NbRamesUsed nbRamesUsed){
        int nbHighVoiles = (actionOnVoiles == VoileAction.DO_NOTHING && ship.getVoiles().get(0).isOpenned()) || (actionOnVoiles == VoileAction.LIFT) ? NB_VOILES : 0;
        double anglePart = getAngleToTurn(rudderAngle, nbRamesUsed)/NB_PART;
        double speedPart;
        Position newPosition = new Position(ship.getPosition().x,ship.getPosition().y,ship.getPosition().orientation);

        for (double i = 0; i < NB_PART; i++) {
            speedPart = getSpeed(nbHighVoiles, nbRamesUsed, newPosition.orientation)/NB_PART;
            newPosition = newPosition.calculateNewPosition(anglePart,speedPart);
        }
        return newPosition;
    }

    //angle we are going to turn using the elements given
    public double getAngleToTurn(double rudderAngle, NbRamesUsed nbRamesUsed){
        return rudderAngle + ((nbRamesUsed.onRight() - nbRamesUsed.onLeft())*Math.PI/NB_RAMES);
    }


    //speed we are going to have using the elements given
    public double getSpeed(int nbHighVoiles, NbRamesUsed nbRamesUsed, double shipOrientation){
        double speedWithRames = 165.0*(nbRamesUsed.onLeft() + nbRamesUsed.onRight())/NB_RAMES;
        double speedWithWind = (1.0*nbHighVoiles/NB_VOILES)*wind.getStrength()*Math.cos(shipOrientation - wind.getOrientation());
        return speedWithRames + speedWithWind;
    }

    public Boolean isCheckpointPassed(Position checkpointPosition, double rudderAngle, VoileAction actionOnVoiles, NbRamesUsed nbRamesUsed){
        Position nextTurnPosition = resolveNextTurnPosition(rudderAngle, actionOnVoiles, nbRamesUsed);
        Geometry geometry = new Geometry(nextTurnPosition);
        if(Math.abs(geometry.calculateAngleToCheckPoint(checkpointPosition)) > Math.PI/2)
            return regattaGoal.getActualCheckpoint().getPosition().getNorm(nextTurnPosition) > regattaGoal.getActualCheckpoint().getRadius();
        return false;
    }
}
