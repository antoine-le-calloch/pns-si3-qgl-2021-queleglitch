package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.VoilesStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;

public class RegattaResolver {

    Geometry geometry;
    OarStrategy oarStrategy;
    RudderStrategy rudderStrategy;
    VoilesStrategy voilesStrategy;
    InformationGame informationGame;

    public RegattaResolver(InformationGame informationGame, NextRound nextRound) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame);
        oarStrategy = new OarStrategy(informationGame);
        rudderStrategy = new RudderStrategy(informationGame);
        voilesStrategy = new VoilesStrategy(informationGame,nextRound);
    }

    public ToolsToUse resolveRegatta(){
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(((RegattaGoal) informationGame.getGoal()).getPositionActualOptiCheckpoint());

        double rudderAngle = this.rudderStrategy.getRudderAngle(angleToCorrect);
        int actionOnVoiles = this.voilesStrategy.getVoilesAction();
        int differenceOarRightLeft = oarStrategy.getDifferenceOarRightLeft(angleToCorrect);
        int[] tabNbLeftAndRightOar = oarStrategy.getNbLeftAndRightOar(rudderAngle != 0, Math.abs(actionOnVoiles), differenceOarRightLeft);

        return new ToolsToUse(rudderAngle,actionOnVoiles,tabNbLeftAndRightOar[0],tabNbLeftAndRightOar[1]);
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
