package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartmoving;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.LiftSail;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.LowerSail;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;

import java.util.List;

public class MovingToSails {

    List<Sail> sails;
    Tooling tooling;

    public MovingToSails(List<Sail> sails, Tooling tooling){
        this.sails = sails;
        this.tooling = tooling;
    }

    public void movingAndUseSails(SailAction actionOnSail, List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        Sailor sailorToMove;
        for (Sail sail : sails) {
            if((sailorToMove = tooling.nearestSailorBehind5(sail, sailorsAvailable)) != null){
                actionsList.add(tooling.buildMovingAction(sailorToMove,sail));
                actionsList.add((actionOnSail == SailAction.LIFT) ? new LiftSail(sailorToMove.getId()) : new LowerSail(sailorToMove.getId()));
                sailorsAvailable.remove(sailorToMove);
            }
            else {
                entitiesTooFar.add(sail);
            }
        }
    }
}
