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
        movingAndUseOarsOnSide(leftOars, nbOarsUsed, sailorsAvailable, entitiesTooFar, actionsList);
        movingAndUseOarsOnSide(rightOars, nbOarsUsed, sailorsAvailable, entitiesTooFar, actionsList);
    }
    
    public void AddToActionList(Sailor sailorToMove,List<Oar> sideOars, List<Action> actionsList, List<Sailor> sailorsAvailable, int j) {
        actionsList.add(tooling.buildMovingAction(sailorToMove, sideOars.get(j)));
        actionsList.add(new Row(sailorToMove.getId()));
        sailorsAvailable.remove(sailorToMove);
    }

    public Sailor getNearestSailorBehind5OnThisSide(List<Oar> sideOars, List<Sailor> sailorsAvailable, int j){
        return tooling.nearestSailorBehind5(sideOars.get(j),sailorsAvailable);
    }

    public int nbOarsUsedOnSide(List<Oar> sideOars,NbOarsUsed nbOarsUsed){
        if(sideOars.equals(leftOars))
            return nbOarsUsed.onLeft();
        else if(sideOars.equals(rightOars))
            return nbOarsUsed.onRight();
        return 0;
    }

    public void movingAndUseOarsOnSide(List<Oar> sideOars, NbOarsUsed nbOarsUsed, List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        Sailor sailorToMove = null;
        for (int i = 0; i < nbOarsUsedOnSide(sideOars,nbOarsUsed); i++) {
            for (int j = sideOars.size() - i - 1; j >= nbOarsUsedOnSide(sideOars,nbOarsUsed) - i -1; j--) {
                if((sailorToMove = getNearestSailorBehind5OnThisSide(sideOars,sailorsAvailable,j)) != null) {
                    AddToActionList(sailorToMove,sideOars,actionsList,sailorsAvailable,j);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(sideOars.get((i == 0) ? nbOarsUsed.onLeft() : sideOars.size()-i));
                break;
            }
        }
    }
}
