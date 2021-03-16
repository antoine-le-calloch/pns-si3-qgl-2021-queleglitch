package fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul;

import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartCreateActions {

    private final Ship ship;
    private final Sailor []sailors;
    private final Rame []leftRames;
    private final Rame []rightRames;
    private final Gouvernail gouvernail;
    private final List<Voile> voiles;
    private final List<Sailor> sailorsAvailable;
    public final List<Entities> entitiesTooFar;
    public final List<Action> actionsList;

    public SmartCreateActions(Sailor[] sailors, Ship ship){
        actionsList = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();

        this.ship = ship;
        this.sailors = sailors;
        this.sailorsAvailable = new ArrayList<>(Arrays.asList(sailors));// maybe clone(), Eric le bouf
        this.gouvernail = ship.getGouvernail();
        this.voiles = ship.getVoiles();
        this.leftRames = ship.getRamesAtLeft().toArray(Rame[]::new);
        this.rightRames = ship.getRamesAtRight().toArray(Rame[]::new);
    }

    public List<Action> createActions(int nbLeftRamesToUse, int nbRightRamesToUse, double rudderAngle, int useVoile){
        if(rudderAngle != 0) {
            movingAndUseGouvernail(rudderAngle);
        }
        if(useVoile != 0) {
            movingAndUseVoiles(useVoile);
        }
        movingAndUseRames(nbLeftRamesToUse, nbRightRamesToUse);
        movingToEntitiesTooFar();
        movingToCenter();

        return actionsList;
    }

    public void movingToCenter(){
        for(Sailor sailor : sailorsAvailable){
            actionsList.add(buildMovingAction(sailor,ship.getCentralPosition()));
        }
    }

    public void movingToEntitiesTooFar(){
        for (Entities entitie : entitiesTooFar) {
            actionsList.add(buildMovingAction(sailorsAvailable.get(0),entitie));
            sailorsAvailable.remove(0);
        }
    }

    public void movingAndUseRames(int nbLeftRamesToUse, int nbRightRamesToUse){
        Sailor sailorToMove = null;
        for (int i = 0; i < nbLeftRamesToUse; i++) {
            for (int j = leftRames.length - i - 1; j >= nbLeftRamesToUse - i -1; j--) {
                if((sailorToMove = nearestSailorBehind5(leftRames[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, leftRames[j]));
                    actionsList.add(new Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(leftRames[(i == 0) ? nbLeftRamesToUse : leftRames.length-i]);
                break;
            }
        }

        for (int i = 0; i < nbRightRamesToUse; i++) {
            for (int j = leftRames.length - i - 1; j >= nbRightRamesToUse - i - 1; j--) {
                if((sailorToMove = nearestSailorBehind5(rightRames[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, rightRames[j]));
                    actionsList.add(new Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(rightRames[(i == 0) ? nbLeftRamesToUse : leftRames.length-i]);
                break;
            }
        }
    }

    public void movingAndUseVoiles(int useVoile){
        Sailor sailorToMove;
        for (Voile voile : voiles) {
            if((sailorToMove = nearestSailorBehind5(voile, sailorsAvailable)) != null){
                actionsList.add(buildMovingAction(sailorToMove,voile));
                actionsList.add((useVoile > 0) ? new LIFT_SAIL(sailorToMove.getId()) : new LOWER_SAIL(sailorToMove.getId()));
                sailorsAvailable.remove(sailorToMove);
                voile.changeVoile();
            }
            else {
                entitiesTooFar.add(voile);
            }
        }
    }

    public void movingAndUseGouvernail(double rudderAngle){
        Sailor sailorToMove = nearestSailorBehind5(gouvernail, sailorsAvailable);
        if(sailorToMove != null) {
            actionsList.add(buildMovingAction(sailorToMove, gouvernail));
            actionsList.add(new Turn(rudderAngle,sailorToMove.getId()));
            sailorsAvailable.remove(sailorToMove);
        }
        else
            entitiesTooFar.add(gouvernail);
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
                pastSailor.x = pastSailor.x + moveOnX;
                pastSailor.y = pastSailor.y + moveOnY;
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