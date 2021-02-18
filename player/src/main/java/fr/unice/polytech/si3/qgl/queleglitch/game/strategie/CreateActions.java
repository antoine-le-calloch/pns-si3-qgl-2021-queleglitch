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

    int MAX_ROWER = 4; //A changer

    public CreateActions(Ship ship, Sailor[] sailors, ToolsToUse toolsToUse) {
        this.ship = ship;
        this.sailors = sailors;
        this.toolsToUse = toolsToUse;
    }

    public List<Action> buildingActions() {
        List<Action> actions = new ArrayList<>();
        List<Action> actionsOar = new ArrayList<>();
        List<Action> actionsTurn = new ArrayList<>();
        List<Rame> rightRames = ship.getRamesAtRight();
        List<Rame> leftRames = ship.getRamesAtLeft();
        double angle;
        int i = 0;
        int x;
        int y;

        for (;i < toolsToUse.getNbLeftOarToUse()+toolsToUse.getNbRightOarToUse(); i++) {
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
        if(i<MAX_ROWER && (angle = toolsToUse.getRudderAngle()) != 0){
            x = ship.getGouvernail().getX() - sailors[i].x;
            y = ship.getGouvernail().getY() - sailors[i].y;
            actions.add(new Moving(sailors[i].getId(),x,y));
            actionsTurn.add(new Turn(sailors[i].getId(),angle));
        }
        actions.addAll(actionsOar);
        actions.addAll(actionsTurn);
        return actions;
    }

    public List<Action> getActions(){
        return buildingActions();
    }
}
