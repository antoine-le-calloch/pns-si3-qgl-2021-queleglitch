package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
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
        int[] tabNbLeftAndRightOar = oarStrategy.getNbLeftAndRightOar(rudderAngle != 0,actionOnVoiles != VoileAction.DO_NOTHING, differenceOarRightLeft);

        if(Math.abs(angleToCorrect) < Math.PI/4) {
            while (shipMovementResolver.isCheckpointPassed(positionCheckpointToReach, rudderAngle, actionOnVoiles, tabNbLeftAndRightOar)) {
                if (tabNbLeftAndRightOar[0] >= 1 && tabNbLeftAndRightOar[1] >= 1 && tabNbLeftAndRightOar[0] + tabNbLeftAndRightOar[1] != 2) {
                    tabNbLeftAndRightOar[0]--;
                    tabNbLeftAndRightOar[1]--;
                } else if (actionOnVoiles != VoileAction.LOWER)
                    actionOnVoiles = informationGame.getShip().getVoiles().get(0).isOpenned() ? VoileAction.LOWER : VoileAction.DO_NOTHING;
                else
                    return null;
            }
        }
        return new ToolsToUse(rudderAngle,actionOnVoiles,tabNbLeftAndRightOar);
    }
}
