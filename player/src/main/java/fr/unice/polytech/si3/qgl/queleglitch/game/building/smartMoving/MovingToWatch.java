package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.UseWatch;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Watch;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;

import java.util.List;

public class MovingToWatch {

    private final Tooling tooling;
    private final Watch watch;

    public MovingToWatch(Watch watch, Tooling tooling){
        this.watch = watch;
        this.tooling = tooling;
    }

    public void movingAndUseWatch(List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        Sailor sailorToMove = tooling.nearestSailorBehind5(watch, sailorsAvailable);
        if(sailorToMove != null) {
            actionsList.add(tooling.buildMovingAction(sailorToMove, watch));
            actionsList.add(new UseWatch(sailorToMove.getId()));
            sailorsAvailable.remove(sailorToMove);
        }
        else
            entitiesTooFar.add(watch);
    }
}