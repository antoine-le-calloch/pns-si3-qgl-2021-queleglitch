package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.VoilesStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;

public class RegattaStrategy {

    Geometry geometry;
    OarStrategy oarStrategy;
    RudderStrategy rudderStrategy;
    VoilesStrategy voilesStrategy;
    InformationGame informationGame;

    public RegattaStrategy(InformationGame informationGame, NextRound nextRound) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame);
        oarStrategy = new OarStrategy(informationGame);
        rudderStrategy = new RudderStrategy(informationGame);
        voilesStrategy = new VoilesStrategy(informationGame,nextRound);
    }

    public ToolsToUse resolveRegatta(){
        Double angleToCorrect = geometry.calculateAngleToCheckPoint(((RegattaGoal) informationGame.getGoal()).getPositionActualOptiCheckpoint());

        double rudderAngle = this.rudderStrategy.getRudderStrategy(angleToCorrect);
        int actionsOnVoiles = this.voilesStrategy.getVoilesStrategy();
        int differenceOarRightLeft = (int) oarStrategy.getDifferenceOarRightLeftStrategy(angleToCorrect);

        return new ToolsToUse(rudderStrategy,numberOfSailor,voilesStrategy);
    }

    public Geometry getGeometry() {
        return geometry;
    }
}
