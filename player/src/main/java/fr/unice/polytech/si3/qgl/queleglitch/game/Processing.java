package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.CreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaStrategy;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

import java.util.List;

public class Processing {

    InformationGame informationGame;
    RegattaStrategy regattaStrategy;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
        ((RegattaGoal) informationGame.getGoal()).calculateOptiCheckpoint();
    }

    public void setDataNewRound(NextRound nextRound){
        informationGame.setShip(nextRound.getShip());
        regattaStrategy = new RegattaStrategy(informationGame, nextRound);

        if(regattaStrategy.getGeometry().isCheckpointReached()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    public List<Action> actionForTheRound(){
        ToolsToUse toolsToUse = regattaStrategy.resolveRegatta();
        CreateActions createActions = new CreateActions(informationGame.getShip(), informationGame.getSailors(), toolsToUse);
        return createActions.buildingActions();
    }
}
