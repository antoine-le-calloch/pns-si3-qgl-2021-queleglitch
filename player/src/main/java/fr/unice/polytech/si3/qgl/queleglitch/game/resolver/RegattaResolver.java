package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbRamesUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.VoilesStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class RegattaResolver {

    Geometry geometry;
    OarStrategy oarStrategy;
    RudderStrategy rudderStrategy;
    VoilesStrategy voilesStrategy;
    InformationGame informationGame;
    ShipMovementResolver shipMovementResolver;

    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame.getShip().getPosition());
        oarStrategy = new OarStrategy(informationGame.getSailors().length, informationGame.getShip().getRames().size());
        rudderStrategy = new RudderStrategy(informationGame);
        voilesStrategy = new VoilesStrategy(informationGame);
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
    }


    public RegattaResolver(Geometry geometry, OarStrategy oarStrategy, RudderStrategy rudderStrategy, VoilesStrategy voilesStrategy,ShipMovementResolver shipMovementResolver) {
        this.geometry = geometry;
        this.oarStrategy = oarStrategy;
        this.rudderStrategy = rudderStrategy;
        this.voilesStrategy = voilesStrategy;
        this.informationGame = new InformationGame();
        this.shipMovementResolver = shipMovementResolver;
    }

    public ToolsToUse resolveToolsToUse(Position positionCheckpointToReach) {
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(positionCheckpointToReach);
        double rudderAngle = rudderStrategy.getRudderAngle(angleToCorrect);
        VoileAction actionOnVoiles = voilesStrategy.getVoilesAction();
        int differenceOarRightLeft = oarStrategy.getDifferenceOarRightLeft(angleToCorrect);
        NbRamesUsed nbRamesUsed = oarStrategy.getNbRamesUsed(rudderAngle != 0,actionOnVoiles != VoileAction.DO_NOTHING, differenceOarRightLeft);
        int maxLeftOarUse = nbRamesUsed.onLeft();
        int maxRightOarUse = nbRamesUsed.onRight();
        boolean changeVoileSetting = false;

        if(Math.abs(angleToCorrect) < Math.PI/4) {
            while (shipMovementResolver.isCheckpointPassed(positionCheckpointToReach, rudderAngle, actionOnVoiles, nbRamesUsed)) {
                if (nbRamesUsed.onLeft() >= 1 && nbRamesUsed.onRight() >= 1 && (nbRamesUsed.onLeft() != nbRamesUsed.onRight() || nbRamesUsed.onLeft() != 1))
                    nbRamesUsed.decreaseLeftAndRight(1);

                else if (informationGame.getShip().getVoiles().get(0).isOpenned() && actionOnVoiles != VoileAction.LOWER){
                    actionOnVoiles = VoileAction.LOWER;
                    changeVoileSetting = true;
                }
                else
                    return null;
            }
            if(changeVoileSetting) {
                while (!shipMovementResolver.isCheckpointPassed(positionCheckpointToReach, rudderAngle, actionOnVoiles, new NbRamesUsed(nbRamesUsed.onLeft()+1,nbRamesUsed.onRight()+1))) {
                    if (nbRamesUsed.onLeft()+1 > maxLeftOarUse || nbRamesUsed.onRight()+1 > maxRightOarUse)
                        break;
                    nbRamesUsed.increaseLeftAndRight(1);
                }
            }
        }
        return new ToolsToUse(rudderAngle,actionOnVoiles,nbRamesUsed);
    }
}
