package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Voile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartCreateActions {

    private final Ship ship;
    private final Sailor []sailors;
    private final Rame []leftRames;
    private final Rame[]rightRames;
    private final Gouvernail gouvernail;
    private final List<Voile> voiles;
    private final List<Sailor> sailorsAvailable;
    public final List<Entities> entitiesTooFar;
    public final List<Action> actionsList;

    public SmartCreateActions(Ship ship, Sailor[] sailors){
        actionsList = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();

        this.ship = ship;
        this.sailors = sailors;
        this.voiles = ship.getVoiles();
        this.gouvernail = ship.getGouvernail();
        this.leftRames = ship.getRamesAtLeft().toArray(Rame[]::new);
        this.rightRames = ship.getRamesAtRight().toArray(Rame[]::new);
        this.sailorsAvailable = new ArrayList<>(Arrays.asList(sailors));
    }

    public List<Action> createActions(ToolsToUse toolsToUse){
        if(toolsToUse.getRudderAngle() != 0) {
            movingAndUseGouvernail(toolsToUse.getRudderAngle());
        }
        if(toolsToUse.getActionOnVoile() != VoileAction.DO_NOTHING) {
            movingAndUseVoiles(toolsToUse.getActionOnVoile());
        }
        movingAndUseRames(toolsToUse.getTabNbLeftAndRightOar());
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

    public void movingAndUseRames(int[] tabNbLeftAndRightOar){
        Sailor sailorToMove = null;
        for (int i = 0; i < tabNbLeftAndRightOar[0]; i++) {
            for (int j = leftRames.length - i - 1; j >= tabNbLeftAndRightOar[0] - i -1; j--) {
                if((sailorToMove = nearestSailorBehind5(leftRames[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, leftRames[j]));
                    actionsList.add(new Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(leftRames[(i == 0) ? tabNbLeftAndRightOar[0] : leftRames.length-i]);
                break;
            }
        }

        for (int i = 0; i < tabNbLeftAndRightOar[1]; i++) {
            for (int j = leftRames.length - i - 1; j >= tabNbLeftAndRightOar[1] - i - 1; j--) {
                if((sailorToMove = nearestSailorBehind5(rightRames[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, rightRames[j]));
                    actionsList.add(new Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(rightRames[(i == 0) ? tabNbLeftAndRightOar[1] : leftRames.length-i]);
                break;
            }
        }
    }

    public void movingAndUseVoiles(VoileAction actionOnVoile){
        Sailor sailorToMove;
        for (Voile voile : voiles) {
            if((sailorToMove = nearestSailorBehind5(voile, sailorsAvailable)) != null){
                actionsList.add(buildMovingAction(sailorToMove,voile));
                actionsList.add((actionOnVoile == VoileAction.LIFT) ? new LiftSail(sailorToMove.getId()) : new LowerSail(sailorToMove.getId()));
                sailorsAvailable.remove(sailorToMove);
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