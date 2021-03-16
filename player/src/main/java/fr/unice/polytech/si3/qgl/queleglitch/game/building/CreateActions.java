package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul.SmartCreateActions;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul.SmartFindNbOar;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.List;

public class CreateActions {
    Ship ship;
    Sailor[] sailors;
    ToolsToUse toolsToUse;
    int MAX_ROWER;

    public CreateActions(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        this.ship = ship;
        this.sailors = sailors;
        this.toolsToUse = toolsToUse;
        this.MAX_ROWER = sailors.length;
    }

    public List<Action> buildingActions() {
        SmartFindNbOar smartFindNbOar = new SmartFindNbOar(MAX_ROWER,ship.getRames().size(),toolsToUse.moreSailorsOnTheRightThanOnTheLeft);
        SmartCreateActions smartCreateActions = new SmartCreateActions(sailors,ship);
        int []nbLeftAndRightOar = smartFindNbOar.getNbLeftAndRightOar(toolsToUse.angleRudder != 0, toolsToUse.numberOfSail != 0);

        return smartCreateActions.createActions(nbLeftAndRightOar[0],nbLeftAndRightOar[1],toolsToUse.angleRudder,toolsToUse.numberOfSail);
    }
}