package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

import java.util.ArrayList;
import java.util.List;

public class Game {

    InformationGame informationGame;
    RegattaResolver regattaResolver;

    public Game(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.regattaResolver= new RegattaResolver(informationGame);
    }

    public void setDataNewRound(NextRound nextRound){
        informationGame.setShip(nextRound.getShip());

        if(regattaResolver.positionResolver.isCheckpointReached()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    public List<Action> actionForTheRound(){
        regattaResolver.resolveRegatta();
        //return createActions.getActions();
    }


}
