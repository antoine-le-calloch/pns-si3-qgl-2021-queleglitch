package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
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

    public List<Action> buldingActions() {
        int x;
        int y;
        List<Action> actions = new ArrayList<>();
        List<Action> actionsOar = new ArrayList<>();

        for (int i = 0; i < toolsToUse.getNbLeftOar()+toolsToUse.getNbRightOar(); i++) {
            if(i<toolsToUse.getNbRightOar()) {
                x = ship.getRamesAtRight().get(0).x - sailors[i].x;
                y = ship.getRamesAtRight().get(0).y - sailors[i].y;
                ship.getRamesAtRight().remove(0);
            }
            else{
                x = ship.getRamesAtLeft().get(0).x - sailors[i].x;
                y = ship.getRamesAtLeft().get(0).y - sailors[i].y;
                ship.getRamesAtLeft().remove(0);
            }
            actions.add(new Moving(sailors[i].getId(),x,y));
            actionsOar.add(new Oar(sailors[i].getId()));
        }
        actions.addAll(actionsOar);
        return actions;
    }

    public List<Action> getActions(){
        return buldingActions();
    }
}
