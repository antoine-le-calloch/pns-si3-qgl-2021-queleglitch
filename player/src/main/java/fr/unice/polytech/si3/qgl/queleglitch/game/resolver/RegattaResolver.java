package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.Strategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.VoilesStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;

public class RegattaResolver {

    Geometry geometry;
    Strategy strategy;
    OarStrategy oarStrategy;
    RudderStrategy rudderStrategy;
    VoilesStrategy voilesStrategy;
    InformationGame informationGame;

    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame.getShip().getPosition());
        strategy = new Strategy(informationGame);
        oarStrategy = new OarStrategy(informationGame.sailors.length, informationGame.ship.getRames().size());
        rudderStrategy = new RudderStrategy(informationGame);
        voilesStrategy = new VoilesStrategy(informationGame);
    }

    public ToolsToUse resolveToolsToUse(){
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(((RegattaGoal) informationGame.getGoal()).getPositionActualOptiCheckpoint());

        double rudderAngle = this.rudderStrategy.getRudderAngle(angleToCorrect);
        int actionOnVoiles = this.voilesStrategy.getVoilesAction();
        int differenceOarRightLeft = oarStrategy.getDifferenceOarRightLeft(angleToCorrect);
        int[] tabNbLeftAndRightOar = oarStrategy.getNbLeftAndRightOar(rudderAngle != 0, Math.abs(actionOnVoiles), differenceOarRightLeft);

        return strategy.getToolsToUse(rudderAngle,actionOnVoiles,tabNbLeftAndRightOar[0],tabNbLeftAndRightOar[1]);
    }
}
