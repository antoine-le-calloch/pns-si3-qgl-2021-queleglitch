package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.SmartCreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding.FindPath;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaResolver;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.ShipMovementResolver;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import java.util.List;

public class Processing {

    FindPath findPath;
    InformationGame informationGame;
    RegattaResolver regattaResolver;
    ShipMovementResolver shipMovementResolver;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.informationGame.getRegattaGoal().calculateOptiCheckpoint();
    }

    public void processDataNewRound(){
        findPath = new FindPath(informationGame.getShip().getPosition().toPoint(), informationGame.getVisibleReef());
        informationGame.processCheckpointReached();

        findPath.createPath(informationGame.getRegattaGoal());
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
        regattaResolver = new RegattaResolver(informationGame);

    }

    public List<Action> actionForTheRound(){
        ToolsToUse toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint());
        if(toolsToUse == null)
            toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getActualCheckpoint().getPosition());
        if(toolsToUse == null)
            toolsToUse = new ToolsToUse(0, SailAction.DO_NOTHING,new NbOarsUsed(1,1));

        SmartCreateActions smartCreateActions = new SmartCreateActions(informationGame.getShip(), informationGame.getSailors());
        return smartCreateActions.createActions(toolsToUse);
    }
}