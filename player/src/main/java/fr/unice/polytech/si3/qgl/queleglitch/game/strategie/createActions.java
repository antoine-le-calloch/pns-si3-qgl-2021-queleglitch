package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.*;

import java.util.ArrayList;
import java.util.List;

public class createActions {
    Ship ship;
    Sailor[] sailors;
    ToolsToUse toolsToUse;
    final int NB_SAILOR = 4;

    public createActions(InitGame initGame, ToolsToUse toolsToUse) {
        ship = initGame.getShip();
        sailors = initGame.getSailors();
        this.toolsToUse = toolsToUse;
    }

    public List<Action> buldingActions() {
        int x;
        int y;
        int i = 0;
        double angle;
        List<Action> actionsMoving = new ArrayList<>();
        List<Action> actionsOar = new ArrayList<>();
        List<Action> actionsTurn = new ArrayList<>();

        for (; i < toolsToUse.getNbLeftOar()+toolsToUse.getNbRightOar(); i++) {
            if(i>toolsToUse.getNbRightOar()) {
                x = ship.getRamesAtLeft().get(0).x - sailors[i].x;
                y = ship.getRamesAtLeft().get(0).y - sailors[i].y;
                ship.getRamesAtLeft().remove(0);
            }
            else{
                x = ship.getRamesAtRight().get(0).x - sailors[i].x;
                y = ship.getRamesAtRight().get(0).y - sailors[i].y;
                ship.getRamesAtRight().remove(0);
            }
            actionsMoving.add(new Moving(sailors[i].getId(),x,y));
            actionsOar.add(new Oar(sailors[i].getId()));
        }
        if(i<NB_SAILOR && (angle = toolsToUse.getRudderAngle()) != 0){
            x = ship.getGouvernail().getX() - sailors[i].x;
            y = ship.getGouvernail().getY() - sailors[i].y;
            actionsMoving.add(new Moving(sailors[i].getId(),x,y));
            actionsTurn.add(new Turn(sailors[i].getId(),angle));
        }
        return actionsMoving;
    }

    public List<Action> getActions(){
        return buldingActions();
    }
}
