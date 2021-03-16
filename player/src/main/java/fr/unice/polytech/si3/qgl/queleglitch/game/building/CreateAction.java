package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie.CreateActionsStrategie;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
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

/*
        if (toolsToUse.getNumberOfSail() == 1 && !ship.getVoile().openned && compteur < MAX_ROWER) {
            //MOVING
            x = ship.getVoile().getX() - sailors[compteur].x;
            y = ship.getVoile().getY() - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new LIFT_SAIL(sailors[compteur++].getId()));
                ship.getVoile().setOpenned(true);
            }
        }

        else if (toolsToUse.getNumberOfSail() == 0 && ship.getVoile().openned && compteur < MAX_ROWER){
            x = ship.getVoile().getX() - sailors[compteur].x;
            y = ship.getVoile().getY() - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new LOWER_SAIL(sailors[compteur++].getId()));
                ship.getVoile().setOpenned(false);
            }
        }

        while (MAX_ROWER - compteur >= 2 && i < rightRames.size()  && j < rightRames.size()  && toolsToUse.numberOfSailorMaxBeforeSlowDown > compteur) {
            //MOVING
            x = rightRames.get(i).x - sailors[compteur].x;
            y = rightRames.get(i).y - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Oar(sailors[compteur++].getId()));
            }
            //MOVING
            x = leftRames.get(j).x - sailors[compteur].x;
            y = leftRames.get(j).y - sailors[compteur].y;
            if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Oar(sailors[compteur++].getId()));
            }
            i++;
            j++;
        }
        return actions;

        if (toolsToUse.getAngleRudder() != 0) {
                //MOVING
                x = ship.getGouvernail().getX() - sailors[compteur].x;
                y = ship.getGouvernail().getY() - sailors[compteur].y;
                if(Math.abs(x) + Math.abs(x) <= 5) {
                sailors[compteur].x += x;
                sailors[compteur].y += y;
                actions.add(new Moving(sailors[compteur].getId(), x, y));
                actions.add(new Turn(sailors[compteur++].getId(), toolsToUse.getAngleRudder()));
                }
                }

                if (compteur < Math.abs(toolsToUse.getNumberOfSailor())) {
        if (toolsToUse.moreSailorsOnTheRightThanOnTheLeft > 0) {
        //MOVING
        for (; i < toolsToUse.moreSailorsOnTheRightThanOnTheLeft; i++) {
        x = rightRames.get(i).x - sailors[compteur].x;
        y = rightRames.get(i).y - sailors[compteur].y;
        if(Math.abs(x) + Math.abs(x) <= 5) {
        sailors[compteur].x += x;
        sailors[compteur].y += y;
        actions.add(new Moving(sailors[compteur].getId(), x, y));
        actions.add(new Oar(sailors[compteur++].getId()));
        }
        }


        } else {
        //MOVING
        double max = toolsToUse.moreSailorsOnTheRightThanOnTheLeft * (-1);
        for (; j < max; j++) {
        x = leftRames.get(j).x - sailors[compteur].x;
        y = leftRames.get(j).y - sailors[compteur].y;
        if(Math.abs(x) + Math.abs(x) <= 5) {
        sailors[compteur].x += x;
        sailors[compteur].y += y;
        actions.add(new Moving(sailors[compteur].getId(), x, y));
        actions.add(new Oar(sailors[compteur++].getId()));
*/