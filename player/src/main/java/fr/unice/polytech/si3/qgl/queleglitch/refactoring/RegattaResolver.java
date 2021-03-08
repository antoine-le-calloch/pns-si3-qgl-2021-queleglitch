package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class RegattaResolver {

    InformationGame informationGame;
    PositionResolver positionResolver;
    OarActionSailorsResolver oarAction;
    RudderActionSailorsResolver rudderAction;


    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        positionResolver = new PositionResolver(informationGame);
    }

    ToolsToUse resolveRegatta(){

        Double angleToCorrect = positionResolver.calculateAngleToCheckPoint();
        double numberOfSailor = oarAction.actionResolver(angleToCorrect);
        double angleRudder = rudderAction.actionResolver(angleToCorrect);
        double numberOfSail = 0;

        return new ToolsToUse(angleRudder,numberOfSailor,numberOfSail);

    }



}
