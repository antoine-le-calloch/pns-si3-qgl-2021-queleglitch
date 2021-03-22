package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class ShipMovementResolver {

    private final int LIFT = 0;
    private final int DO_NOTHING = 0;
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

    public Boolean isCheckpointPassed(Position checkpointPosition, double rudderAngle, int actionOnVoiles, int []tabNbLeftAndRightOar){
        Position nextTurnPosition = resolveNextTurnPosition(rudderAngle, actionOnVoiles, tabNbLeftAndRightOar);
        Geometry geometry = new Geometry(nextTurnPosition);
        if(Math.abs(geometry.calculateAngleToCheckPoint(checkpointPosition)) > Math.PI/2)
            return regattaGoal.getActualCheckpoint().position.getNorm(ship.getPosition()) > ((Circle) regattaGoal.getActualCheckpoint().getShape()).radius;
        return false;
    }

    //angle we are going to turn using the elements given by this object
    public double getAngleToTurn(double rudderAngle, int[] tabNbLeftAndRightOar){
        return rudderAngle + ((tabNbLeftAndRightOar[1] - tabNbLeftAndRightOar[0])*Math.PI/NB_RAMES);
    }


    //speed we are going to have using the elements given by this object
    public double getSpeed(int nbHighVoiles, int[] tabNbLeftAndRightOar, double shipOrientation){
        double speedWithRames = 165.0*(tabNbLeftAndRightOar[0]+tabNbLeftAndRightOar[1])/NB_RAMES;
        double speedWithWind = (1.0* nbHighVoiles/NB_VOILES)*wind.strength*Math.cos(Math.abs(shipOrientation - wind.orientation));
        return speedWithRames + speedWithWind;
    }

    public Position resolveNextTurnPosition(double rudderAngle, int actionOnVoiles, int[] tabNbLeftAndRightOar){
        int nbHighVoiles = (actionOnVoiles == DO_NOTHING && ship.getVoiles().get(0).opened) || (actionOnVoiles == LIFT)?NB_VOILES:0;
        double anglePart = getAngleToTurn(rudderAngle, tabNbLeftAndRightOar)/NB_PART;
        double speedPart;
        Position newPosition = new Position(ship.getPosition().x,ship.getPosition().y,ship.getPosition().orientation);

        for (double i = 0; i < NB_PART; i++) {
            speedPart = getSpeed(nbHighVoiles, tabNbLeftAndRightOar, newPosition.orientation)/NB_PART;
            newPosition = newPosition.calculateNewPosition(anglePart,speedPart);
        }
        return newPosition;
    }
}
