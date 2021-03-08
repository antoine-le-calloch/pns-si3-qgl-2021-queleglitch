package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

import java.util.List;

public class Processing {

    InformationGame informationGame;
    RegattaResolver regattaResolver;

    public Processing(InformationGame informationGame) {
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
        ToolsToUse toolsToUse = regattaResolver.resolveRegatta();
        CreateAction createAction = new CreateAction(informationGame.getShip(), informationGame.getSailors(), toolsToUse);
        return createAction.buildingActions();
    }


}
