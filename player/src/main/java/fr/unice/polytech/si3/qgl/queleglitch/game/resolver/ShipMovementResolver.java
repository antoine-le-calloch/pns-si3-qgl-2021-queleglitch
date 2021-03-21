package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

public class ShipMovementResolver {

    private final int DO_NOTHING = 0;

    private final int NB_RAMES;
    private final int NB_VOILES;
    private final Ship ship;
    private final Wind wind;
    private double rudderAngle;
    private int nbRightRamesToUse;
    private int nbLeftRamesToUse;
    private int nbVoilesHigh = 0;

    public ShipMovementResolver(Ship ship, Wind wind){
        this.ship = ship;
        this.wind = wind;
        NB_RAMES = ship.getRames().size();
        NB_VOILES = ship.getVoiles().size();
    }

    public void setNewShipState(double rudderAngle, int actionOnVoiles, int nbLeftRamesToUse, int nbRightRamesToUse){
        this.rudderAngle = rudderAngle;
        this.nbRightRamesToUse = nbRightRamesToUse;
        this.nbLeftRamesToUse = nbLeftRamesToUse;
        if(actionOnVoiles == DO_NOTHING && ship.getVoiles().get(0).opened)
            nbVoilesHigh = ship.getVoiles().size();
        else
            nbVoilesHigh = Math.max(actionOnVoiles,0);
    }

    //angle we are going to turn using the elements given by this object
    public double getAngleToTurn(){
        return rudderAngle + ((nbRightRamesToUse - nbLeftRamesToUse)*Math.PI/NB_RAMES);
    }


    //speed we are going to have using the elements given by this object
    public double getSpeed(double shipOrientation){
        double speedWithRames = 165.0*(nbLeftRamesToUse+nbRightRamesToUse)/NB_RAMES;
        double speedWithWind = (1.0* nbVoilesHigh/NB_VOILES)*wind.strength*Math.cos(Math.abs(shipOrientation - wind.orientation));
        return speedWithRames + speedWithWind;
    }

    public Position resolveNextTurnPosition(int nbPart){
        double anglePart = getAngleToTurn()/nbPart;
        double speedPart;
        Position newPosition = new Position(ship.getPosition().x,ship.getPosition().y,ship.getPosition().orientation);

        for (double i = 0; i < nbPart; i++) {
            speedPart = getSpeed(newPosition.orientation)/nbPart;
            newPosition = newPosition.calculateNewPosition(anglePart,speedPart);
        }
        return newPosition;
    }
}
