package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul.SmartCreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.List;

public class CreateActions {

    SmartCreateActions smartCreateActions;
    ToolsToUse toolsToUse;

    public CreateActions(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        smartCreateActions = new SmartCreateActions(sailors,ship);
        this.toolsToUse = toolsToUse;
    }

    public List<Action> buildingActions() {


        return smartCreateActions.createActions(toolsToUse.rudderAngle, toolsToUse.actionOnVoiles, toolsToUse.nbLeftRamesToUse, toolsToUse.nbRightRamesToUse);
    }
}