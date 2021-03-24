package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Row;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;

import java.util.List;

public class MovingToOars {

    List<Oar> leftOars;
    List<Oar> rightOars;
    Tooling tooling;

    public MovingToOars(List<Oar> leftOars, List<Oar> rightOars, Tooling tooling){
        this.leftOars = leftOars;
        this.rightOars = rightOars;
        this.tooling = tooling;
    }

    public void movingAndUseOars(NbOarsUsed nbOarsUsed, List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        Sailor sailorToMove = null;
        for (int i = 0; i < nbOarsUsed.onLeft(); i++) {
            for (int j = leftOars.size() - i - 1; j >= nbOarsUsed.onLeft() - i -1; j--) {
                if((sailorToMove = tooling.nearestSailorBehind5(leftOars.get(j), sailorsAvailable)) != null) {
                    actionsList.add(tooling.buildMovingAction(sailorToMove, leftOars.get(j)));
                    actionsList.add(new Row(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(leftOars.get((i == 0) ? nbOarsUsed.onLeft() : leftOars.size()-i));
                break;
            }
        }

        for (int i = 0; i < nbOarsUsed.onRight(); i++) {
            for (int j = leftOars.size() - i - 1; j >= nbOarsUsed.onRight() - i - 1; j--) {
                if((sailorToMove = tooling.nearestSailorBehind5(rightOars.get(j), sailorsAvailable)) != null) {
                    actionsList.add(tooling.buildMovingAction(sailorToMove, rightOars.get(j)));
                    actionsList.add(new Row(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(rightOars.get((i == 0) ? nbOarsUsed.onRight() : leftOars.size()-i));
                break;
            }
        }
    }
}
