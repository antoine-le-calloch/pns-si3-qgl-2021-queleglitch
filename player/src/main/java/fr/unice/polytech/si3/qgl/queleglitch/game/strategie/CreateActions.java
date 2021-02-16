package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;

import java.util.ArrayList;
import java.util.List;

public class CreateActions {
    Ship ship;
    Sailor[] sailors;
    ToolsToUse toolsToUse;

    public CreateActions(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        this.ship = ship;
        this.sailors = sailors;
        this.toolsToUse = toolsToUse;
    }

    public List<Action> buildingActions() {
        List<Action> actions = new ArrayList<>();
        List<Action> actionsOar = new ArrayList<>();
        List<Rame> rightRames = ship.getRamesAtRight();
        List<Rame> leftRames = ship.getRamesAtLeft();
        int x;
        int y;

        for (int i = 0; i < toolsToUse.getNbLeftOarToUse()+toolsToUse.getNbRightOarToUse(); i++) {
            if(i<toolsToUse.getNbRightOarToUse()) {
                x = rightRames.get(i).x - sailors[i].x;
                y = rightRames.get(i).y - sailors[i].y;
            }
            else{
                x = leftRames.get(i-toolsToUse.getNbRightOarToUse()).x - sailors[i].x;
                y = leftRames.get(i-toolsToUse.getNbRightOarToUse()).y - sailors[i].y;
            }
            sailors[i].x += x;
            sailors[i].y += y;
            actions.add(new Moving(sailors[i].getId(),x,y));
            actionsOar.add(new Oar(sailors[i].getId()));
        }
        actions.addAll(actionsOar);
        return actions;
    }

    public List<Action> getActions(){
        return buildingActions();
    }
}
