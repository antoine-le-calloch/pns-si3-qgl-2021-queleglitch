package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.CreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaResolver;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.ShipMovementResolver;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

import java.util.List;

public class Processing {

    InformationGame informationGame;
    RegattaResolver regattaResolver;
    ShipMovementResolver shipMovementResolver;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
        informationGame.getRegattaGoal().calculateOptiCheckpoint();
    }

    public void setDataNewRound(Ship ship, Wind wind){
        shipMovementResolver = new ShipMovementResolver(ship,wind, informationGame.getRegattaGoal());
        informationGame.setShip(ship);
        informationGame.setWind(wind);
        regattaResolver = new RegattaResolver(informationGame);

        if(informationGame.isCheckpointReached()){
            informationGame.moveToNextCheckpoint();
        }
    }

    public List<Action> actionForTheRound(){
        ToolsToUse toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint());
        if(toolsToUse == null)
            toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getActualCheckpoint().getPosition());
        CreateActions createActions = new CreateActions(informationGame.getShip(), informationGame.getSailors(), toolsToUse);
        return createActions.buildingActions();
    }
}
