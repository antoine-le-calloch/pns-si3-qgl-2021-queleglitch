package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

public class RegattaResolver {

    InformationGame informationGame;
    PositionResolver positionResolver;
    WindResolver windResolver;
    SailorsResolver sailorsResolver;


    public RegattaResolver(InformationGame informationGame) {
        this.informationGame = informationGame;
        positionResolver=new PositionResolver(informationGame);
    }

    void resolveRegatta(){
        Double angleToCorrect = positionResolver.calculateAngleToCheckPoint();
        //sailorsResolver.rudderResolver();
        Boolean isJudiciousToOpenTheSails = windResolver.resolveWind();
        sailorsResolver.sailResolver();
        sailorsResolver.oarResolver();
    }


}
