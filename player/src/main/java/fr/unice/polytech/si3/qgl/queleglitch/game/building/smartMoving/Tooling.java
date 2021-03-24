package fr.unice.polytech.si3.qgl.queleglitch.game.building.smartMoving;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Moving;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import java.util.List;

public class Tooling {

    Entities centralPosition;
    Sailor []sailors;

    public Tooling(Entities centralPosition, Sailor[] sailors){
        this.centralPosition = centralPosition;
        this.sailors = sailors;
    }

    public void movingToCenter(List<Sailor> sailorsAvailable, List<Action> actionsList){
        for(Sailor sailor : sailorsAvailable){
            actionsList.add(buildMovingAction(sailor,centralPosition));
        }
    }

    public List<Action> movingToEntitiesTooFar(List<Sailor> sailorsAvailable, List<Entities> entitiesTooFar, List<Action> actionsList){
        for (Entities entitie : entitiesTooFar) {
            actionsList.add(buildMovingAction(sailorsAvailable.get(0),entitie));
            sailorsAvailable.remove(0);
        }
        return actionsList;
    }

    public Action buildMovingAction(Sailor sailor, Entities destination){
        int moveOnX = Math.min(Math.max(destination.getX()-sailor.getX(), -5), 5);
        int moveOnY = Math.min(Math.max(destination.getY()-sailor.getY(), -5), 5);

        if(Math.abs(moveOnX) + Math.abs(moveOnY) > 5) {
            if(moveOnY == 5 || moveOnY == -5)
                moveOnY = (moveOnY > 0) ? moveOnY - 1 : moveOnY + 1;
            moveOnX = (moveOnX < 0) ? -5 + Math.abs(moveOnY) : 5 - Math.abs(moveOnY);
        }

        for (Sailor pastSailor : sailors) {
            if(pastSailor.getId() == sailor.getId()){
                pastSailor.setX(pastSailor.getX() + moveOnX);
                pastSailor.setY(pastSailor.getY() + moveOnY);
                break;
            }
        }

        return new Moving(moveOnX,moveOnY,sailor.getId());
    }

    public Sailor nearestSailorBehind5(Entities placeToMove, List<Sailor> sailors){
        int minBox = 6;
        Sailor sailorToReturn = null;
        for (Sailor sailor : sailors) {
            if(nbBoxBetweenSailorAndPlace(sailor,placeToMove) < minBox){
                minBox = nbBoxBetweenSailorAndPlace(sailor,placeToMove);
                sailorToReturn = sailor;
            }
        }
        return sailorToReturn;
    }

    public int nbBoxBetweenSailorAndPlace(Sailor sailor, Entities place){
        return Math.abs(sailor.getX()-place.getX()) + Math.abs(sailor.getY()-place.getY());
    }
}
