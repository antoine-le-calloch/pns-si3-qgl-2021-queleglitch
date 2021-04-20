package fr.unice.polytech.si3.qgl.queleglitch.game;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.SmartCreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.RegattaResolver;
import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.ShipMovementResolver;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

import java.util.List;

public class Processing {

    Boolean firstTurn = true;
    Boolean secondTurn = false;
    Boolean checkpointReached;
    InformationGame informationGame;
    RegattaResolver regattaResolver;
    ShipMovementResolver shipMovementResolver;

    public Processing(InformationGame informationGame) {
        this.informationGame = informationGame;
        this.informationGame.getRegattaGoal().calculateOptiCheckpoint();
    }

    public void processDataNewRound(){
        if(informationGame.isCheckpointReached()) {
            informationGame.processCheckpointReached();
            checkpointReached = true;
        } else
            checkpointReached = false;

        if(secondTurn) {
            secondTurn = false;
            informationGame.createGrid();
        }

        if(firstTurn || checkpointReached) {
            firstTurn = false;
            secondTurn = true;
            informationGame.createGrid();
            informationGame.getRegattaGoal().setCheckpointReach(true);
        }

        informationGame.createPath();
        shipMovementResolver = new ShipMovementResolver(informationGame.getShip(), informationGame.getWind(), informationGame.getRegattaGoal());
        regattaResolver = new RegattaResolver(informationGame);
        /*System.out.println("checkpoint : " + informationGame.getRegattaGoal().getPositionActualOptiCheckpoint());
        System.out.print("checkpoint col : " + informationGame.getGrid().getColAndLineOfAPosition(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint())[0]);
        System.out.println(",    lin : " + informationGame.getGrid().getColAndLineOfAPosition(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint())[1]);
        System.out.println("case point : " + informationGame.getGrid().getCase(informationGame.getGrid().getColAndLineOfAPosition(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint())[0],informationGame.getGrid().getColAndLineOfAPosition(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint())[1]).getCentralPoint());
        for (Point point : informationGame.getRegattaGoal().getPathPoints()) {
            System.out.print("col : " + informationGame.getGrid().getColAndLineOfAPosition(point.toPosition())[0]);
            System.out.println(", lin : " + informationGame.getGrid().getColAndLineOfAPosition(point.toPosition())[1]);
        }*/
    }

    public List<Action> actionForTheRound(){
        ToolsToUse toolsToUse;
        if(informationGame.getRegattaGoal().getPathPoint() == null) {
            toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getPositionActualOptiCheckpoint(),true);
            if (toolsToUse == null)
                toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getActualCheckpoint().getPosition(),true);
            if (toolsToUse == null)
                toolsToUse = new ToolsToUse(0, SailAction.DO_NOTHING, new NbOarsUsed(1, 1),false);
        }
        else
            toolsToUse = regattaResolver.resolveToolsToUse(informationGame.getRegattaGoal().getPathPoint().toPosition(),false);

        SmartCreateActions smartCreateActions = new SmartCreateActions(informationGame.getShip(), informationGame.getSailors());
        return smartCreateActions.createActions(toolsToUse);
    }
}