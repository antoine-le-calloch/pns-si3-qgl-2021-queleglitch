package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarActionStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderActionStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.WindActionStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;

public class RegattaResolver {

    InformationGame informationGame;
    Geometry geometry;
    OarActionStrategie oarAction;
    RudderActionStrategie rudderAction;
    WindActionStrategie windAction;


    public RegattaResolver(InformationGame informationGame, NextRound nextRound) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame);
        oarAction =new OarActionStrategie(informationGame);
        rudderAction =new RudderActionStrategie(informationGame);
        windAction = new WindActionStrategie(informationGame,nextRound);
    }

    public RegattaResolver(InformationGame informationGame,Geometry geometry,OarActionStrategie oarActionStrategie,RudderActionStrategie rudderActionStrategie){
        this.informationGame=informationGame;
        this.geometry=geometry;
        this.oarAction=oarActionStrategie;
        this.rudderAction=rudderActionStrategie;
    }

    public ToolsToUse resolveRegatta(){

        Double angleToCorrect = geometry.calculateAngleToCheckPoint(((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition());
        int numberOfSail = windAction.windResolver();
        int numberOfSailorMaxBeforeSlowDown = geometry.slowDown();
        int numberOfSailor = (int) oarAction.oarActionResolver(angleToCorrect);
        double angleRudder = rudderAction.rudderActionResolver(angleToCorrect);


        return new ToolsToUse(angleRudder,numberOfSailor,numberOfSail,numberOfSailorMaxBeforeSlowDown);

    }

    public Geometry getGeometry() {
        return geometry;
    }
}
