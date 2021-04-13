package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Watch;

import java.util.List;

public class MovingToWatch {

    private final Tooling tooling;
    private final Watch watch;

    public MovingToWatch(Watch watch, Tooling tooling){
        this.watch = watch;
        this.tooling = tooling;
    }

    public void movingAndUseWatch(List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        //never call
    }
}