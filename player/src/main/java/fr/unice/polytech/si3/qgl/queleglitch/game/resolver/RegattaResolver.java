package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.OarActionStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.RudderActionStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class RegattaResolver {

    InformationGame informationGame;
    Geometry geometry;
    OarActionStrategie oarAction;
    RudderActionStrategie rudderAction;


    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        geometry = new Geometry(informationGame);
        oarAction =new OarActionStrategie(informationGame);
        rudderAction =new RudderActionStrategie(informationGame);
    }

    public RegattaResolver(InformationGame informationGame,Geometry geometry,OarActionStrategie oarActionStrategie,RudderActionStrategie rudderActionStrategie){
        this.informationGame=informationGame;
        this.geometry=geometry;
        this.oarAction=oarActionStrategie;
        this.rudderAction=rudderActionStrategie;
    }

    public ToolsToUse resolveRegatta(){

        Double angleToCorrect = geometry.calculateAngleToCheckPoint(((RegattaGoal) informationGame.getGoal()).getActualCheckpoint().getPosition());
        int numberOfSailorMaxBeforeSlowDown = geometry.slowDown();
        double numberOfSailor = oarAction.actionResolver(angleToCorrect);
        double angleRudder = rudderAction.actionResolver(angleToCorrect);
        double numberOfSail = 0;

        return new ToolsToUse(angleRudder,numberOfSailor,numberOfSail,numberOfSailorMaxBeforeSlowDown);

    }

    public Geometry getGeometry() {
        return geometry;
    }
}
