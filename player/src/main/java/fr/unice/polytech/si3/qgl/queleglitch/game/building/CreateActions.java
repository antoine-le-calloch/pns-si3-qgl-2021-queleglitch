package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.CreateActionsStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.ArrayList;
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
        List<Action> actions = new ArrayList<>();
        CreateActionsStrategie createActionsStrategie = new CreateActionsStrategie(sailors, ship);
        int nbSailorForOar = MAX_ROWER;
        int nbLeftRamesToUse = 0;
        int nbRightRamesToUse = 0;

        if (toolsToUse.getAngleRudder() != 0)
            nbSailorForOar--;
        if (toolsToUse.getNumberOfSail() != 0)
            nbSailorForOar--;

        ///A faire

        return createActionsStrategie.createActions(nbLeftRamesToUse,nbRightRamesToUse,toolsToUse.angleRudder, toolsToUse.numberOfSail);
    }
}