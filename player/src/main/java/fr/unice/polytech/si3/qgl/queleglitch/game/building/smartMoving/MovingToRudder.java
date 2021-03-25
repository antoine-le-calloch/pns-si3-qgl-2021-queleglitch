package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Turn;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Rudder;

import java.util.List;

public class MovingToRudder {

    Tooling tooling;
    Rudder rudder;

    public MovingToRudder(Rudder rudder, Tooling tooling){
        this.tooling = tooling;
        this.rudder = rudder;
    }

    public void movingAndUseRudder(double rudderAngle, List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        Sailor sailorToMove = tooling.nearestSailorBehind5(rudder, sailorsAvailable);
        if(sailorToMove != null) {
            actionsList.add(tooling.buildMovingAction(sailorToMove, rudder));
            actionsList.add(new Turn(rudderAngle,sailorToMove.getId()));
            sailorsAvailable.remove(sailorToMove);
        }
        else
            entitiesTooFar.add(rudder);
    }
}