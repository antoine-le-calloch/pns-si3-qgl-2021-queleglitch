package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Turn;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.ArrayList;
import java.util.List;

public class CreateAction {
    Ship ship;
    Sailor[] sailors;
    ToolsToUse toolsToUse;
    int MAX_ROWER;

    public CreateAction(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        this.ship = ship;
        this.sailors = sailors;
        this.toolsToUse = toolsToUse;
        this.MAX_ROWER = sailors.length;
    }

    public List<Action> buildingActions() {
        List<Action> actions = new ArrayList<>();

        int compteur = 0;

        if (compteur < MAX_ROWER && toolsToUse.getAngleRudder() != 0) {
            actions.add(new Turn(sailors[compteur++].getId(), toolsToUse.getAngleRudder()));
        }

        if (compteur > Math.abs(toolsToUse.getNumberOfSailor())) {
            if (toolsToUse.numberOfSailor > 0) {
                //MOVING
                for (int i = 0; i < toolsToUse.numberOfSailor; i++) {
                    actions.add(new Oar(sailors[compteur++].getId()));
                }
            }
            else {
                //MOVING
                double max = toolsToUse.numberOfSailor * (-1);
                for (int i = 0; i < max; i++) {
                    actions.add(new Oar(sailors[compteur++].getId()));
                }
            }
        }

        /*
        if (compteur > toolsToUse.numberOfSail) {
            //SAIL
        }*/

        while(compteur > 2){
            //MOVING
            actions.add(new Oar(sailors[compteur++].getId()));
            //MOVING
            actions.add(new Oar(sailors[compteur++].getId()));
        }

        return actions;
    }

}
