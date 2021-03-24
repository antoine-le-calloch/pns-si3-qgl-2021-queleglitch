package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Rudder;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartCreateActions {

    private final Ship ship;
    private final Sailor []sailors;
    private final Oar[] leftOars;
    private final Oar[] rightOars;
    private final Rudder rudder;
    private final List<Sail> sails;
    private final List<Sailor> sailorsAvailable;
    public final List<Entities> entitiesTooFar;
    public final List<Action> actionsList;

    public SmartCreateActions(Ship ship, Sailor[] sailors){
        actionsList = new ArrayList<>();
        entitiesTooFar = new ArrayList<>();

        this.ship = ship;
        this.sailors = sailors;
        this.sails = ship.getSails();
        this.rudder = ship.getRudder();
        this.leftOars = ship.getOarsAtLeft().toArray(Oar[]::new);
        this.rightOars = ship.getOarsAtRight().toArray(Oar[]::new);
        this.sailorsAvailable = new ArrayList<>(Arrays.asList(sailors));
    }

    public List<Action> createActions(ToolsToUse toolsToUse){
        if(toolsToUse.getRudderAngle() != 0) {
            movingAndUseRudder(toolsToUse.getRudderAngle());
        }
        if(toolsToUse.getActionOnSail() != SailAction.DO_NOTHING) {
            movingAndUseSails(toolsToUse.getActionOnSail());
        }
        movingAndUseOars(toolsToUse.getNbOarsUsed());
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

    public void movingAndUseOars(NbOarsUsed nbOarsUsed){
        Sailor sailorToMove = null;
        for (int i = 0; i < nbOarsUsed.onLeft(); i++) {
            for (int j = leftOars.length - i - 1; j >= nbOarsUsed.onLeft() - i -1; j--) {
                if((sailorToMove = nearestSailorBehind5(leftOars[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, leftOars[j]));
                    actionsList.add(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(leftOars[(i == 0) ? nbOarsUsed.onLeft() : leftOars.length-i]);
                break;
            }
        }

        for (int i = 0; i < nbOarsUsed.onRight(); i++) {
            for (int j = leftOars.length - i - 1; j >= nbOarsUsed.onRight() - i - 1; j--) {
                if((sailorToMove = nearestSailorBehind5(rightOars[j], sailorsAvailable)) != null) {
                    actionsList.add(buildMovingAction(sailorToMove, rightOars[j]));
                    actionsList.add(new fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar(sailorToMove.getId()));
                    sailorsAvailable.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesTooFar.add(rightOars[(i == 0) ? nbOarsUsed.onRight() : leftOars.length-i]);
                break;
            }
        }
    }

    public void movingAndUseSails(SailAction actionOnSail){
        Sailor sailorToMove;
        for (Sail sail : sails) {
            if((sailorToMove = nearestSailorBehind5(sail, sailorsAvailable)) != null){
                actionsList.add(buildMovingAction(sailorToMove, sail));
                actionsList.add((actionOnSail == SailAction.LIFT) ? new LiftSail(sailorToMove.getId()) : new LowerSail(sailorToMove.getId()));
                sailorsAvailable.remove(sailorToMove);
            }
            else {
                entitiesTooFar.add(sail);
            }
        }
    }

    public void movingAndUseRudder(double rudderAngle){
        Sailor sailorToMove = nearestSailorBehind5(rudder, sailorsAvailable);
        if(sailorToMove != null) {
            actionsList.add(buildMovingAction(sailorToMove, rudder));
            actionsList.add(new Turn(rudderAngle,sailorToMove.getId()));
            sailorsAvailable.remove(sailorToMove);
        }
        else
            entitiesTooFar.add(rudder);
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