package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.MoveSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveActionStrategie {

    Box centralPlace;
    List<MoveSailor> movingActionsList;
    List<Entities> entitiesToFar;
    List<Sailor> sailorsToMove;
    Gouvernail gouvernail;
    Voile []voiles;
    Rame []leftRames;
    Rame []rightRames;
    Ship ship;

    public MoveActionStrategie(){
    }

    public MoveActionStrategie(List<Sailor> sailorsToMove, Gouvernail gouvernail, Box centralPlace, Voile[] voiles, Rame[] leftRames, Rame[] rightRames){
        movingActionsList = new ArrayList<>();
        entitiesToFar = new ArrayList<>();

        this.sailorsToMove = sailorsToMove;
        this.gouvernail = gouvernail;
        this.centralPlace = centralPlace;
        this.voiles = voiles;
        this.leftRames = leftRames;
        this.rightRames = rightRames;
    }

    public MoveActionStrategie(InformationGame informationGame){
        movingActionsList = new ArrayList<>();
        entitiesToFar = new ArrayList<>();

        this.ship = informationGame.getShip();
        this.sailorsToMove = Arrays.asList(informationGame.getSailors().clone());
        this.gouvernail = informationGame.getShip().getGouvernail();
        this.centralPlace = informationGame.getShip().getCentralPosition();
        this.voiles = informationGame.getShip().getVoiles().toArray(Voile[]::new);
        this.leftRames = informationGame.getShip().getRamesAtLeft().toArray(Rame[]::new);
        this.rightRames = informationGame.getShip().getRamesAtRight().toArray(Rame[]::new);
    }

    public List<MoveSailor> movingStrat(int nbLeftRamesToUse, int nbRightRamesToUse, double rudderAngle){
        List<MoveSailor> movingActionsList = this.movingActionsList;
        List<Entities> entitiesToFar = this.entitiesToFar;
        List<Sailor> sailorsToMove = this.sailorsToMove;


        movingToGouvernail(rudderAngle,movingActionsList,sailorsToMove,entitiesToFar);

        movingToVoiles(movingActionsList, sailorsToMove, entitiesToFar);

        movingToRames(nbLeftRamesToUse, leftRames, nbRightRamesToUse, rightRames, movingActionsList, sailorsToMove, entitiesToFar);

        movingToEntitiesToFar(movingActionsList, sailorsToMove, entitiesToFar);

        movingToCenter(movingActionsList, sailorsToMove);

        return movingActionsList;
    }

    public void movingToCenter(List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove){
        for(Sailor sailor : sailorsToMove){
            movingActionsList.add(buildMovingAction(sailor,ship.getCentralPosition()));
        }
    }

    public void movingToEntitiesToFar(List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove, List<Entities> entitiesToFar){
        for (Entities entitie : entitiesToFar) {
            movingActionsList.add(buildMovingAction(sailorsToMove.get(0),entitie));
            sailorsToMove.remove(0);
        }
    }
    public void movingToRames(int nbLeftRamesToUse, Rame []leftRames, int nbRightRamesToUse, Rame []rightRames, List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove, List<Entities> entitiesToFar){
        Sailor sailorToMove = null;
        for (int i = 0; i < nbLeftRamesToUse; i++) {
            for (int j = leftRames.length - i; j >= nbLeftRamesToUse - i; j--) {
                if((sailorToMove = nearestSailorBehind5(leftRames[j], sailorsToMove)) != null) {
                    movingActionsList.add(buildMovingAction(sailorToMove, leftRames[j]));
                    sailorsToMove.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesToFar.add(leftRames[(i == 0) ? nbLeftRamesToUse : leftRames.length-i]);
                break;
            }
        }

        for (int i = 0; i < nbRightRamesToUse; i++) {
            for (int j = leftRames.length - i; j >= nbRightRamesToUse - i; j--) {
                if((sailorToMove = nearestSailorBehind5(rightRames[j], sailorsToMove)) != null) {
                    movingActionsList.add(buildMovingAction(sailorToMove, rightRames[j]));
                    sailorsToMove.remove(sailorToMove);
                    break;
                }
            }
            if(sailorToMove == null) {
                entitiesToFar.add(rightRames[(i == 0) ? nbLeftRamesToUse : leftRames.length-i]);
                break;
            }
        }
    }

    public void movingToVoiles(List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove, List<Entities> entitiesToFar){
        Sailor sailorToMove;
        for (Voile voile : voiles) {
            if((sailorToMove = nearestSailorBehind5(voile, sailorsToMove)) != null){
                movingActionsList.add(buildMovingAction(sailorToMove,gouvernail));
                sailorsToMove.remove(sailorToMove);
                break;
            }
            else
                entitiesToFar.add(voile);
        }
    }

    public void movingToGouvernail(double rudderAngle, List<MoveSailor> movingActionsList, List<Sailor> sailorsToMove, List<Entities> entitiesToFar){
        Sailor sailorToMove;
        if(rudderAngle != 0){
            if((sailorToMove = nearestSailorBehind5(gouvernail, sailorsToMove)) != null) {
                movingActionsList.add(buildMovingAction(sailorToMove, gouvernail));
                sailorsToMove.remove(sailorToMove);
            }
            else
                entitiesToFar.add(gouvernail);
        }
    }

    public MoveSailor buildMovingAction(Sailor sailor, Entities destination){
        int moveOnX = Math.min(Math.max(destination.getX()-sailor.getX(), -5), 5);
        int moveOnY = Math.min(Math.max(destination.getY()-sailor.getY(), -5), 5);

        if(Math.abs(moveOnX) + Math.abs(moveOnY) > 5) {
            if(moveOnY == 5 || moveOnY == -5)
                moveOnY = (moveOnY > 0) ? moveOnY - 1 : moveOnY + 1;
            moveOnX = (moveOnX < 0) ? -5 + Math.abs(moveOnY) : 5 - Math.abs(moveOnY);
        }

        return new MoveSailor(moveOnX,moveOnY,sailor.getId());
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