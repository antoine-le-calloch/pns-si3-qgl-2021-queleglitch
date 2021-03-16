package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.CreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaResolver;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

import java.util.List;

public class Processing {

    InformationGame informationGame;
    RegattaResolver regattaResolver;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
    }

    public void setDataNewRound(NextRound nextRound){
        informationGame.setShip(nextRound.getShip());
        regattaResolver = new RegattaResolver(informationGame, nextRound);

        if(regattaResolver.getGeometry().isCheckpointReached()){
            ((RegattaGoal) informationGame.getGoal()).checkpointReached();
        }
    }

    public List<Action> actionForTheRound(){
        ToolsToUse toolsToUse = regattaResolver.resolveRegatta();
        CreateActions createActions = new CreateActions(informationGame.getShip(), informationGame.getSailors(), toolsToUse);
        return createActions.buildingActions();
    }
}
