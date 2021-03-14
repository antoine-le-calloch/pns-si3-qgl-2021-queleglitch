package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.MoveSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.PositionSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveActionStrategie {

    List<MoveSailor> movingActionsList;
    List<Entities> entitiesToFar;
    Gouvernail gouvernail;
    Sailor []sailors;
    Voile []voiles;
    Rame []leftRames;
    Rame []rightRames;

    public MoveActionStrategie(){
    }

    public MoveActionStrategie(InformationGame informationGame){
        movingActionsList = new ArrayList<>();
        entitiesToFar = new ArrayList<>();

        this.sailors = informationGame.getSailors();
        this.gouvernail = informationGame.getShip().getGouvernail();
        this.voiles = informationGame.getShip().getVoiles().toArray(Voile[]::new);
        this.leftRames = informationGame.getShip().getRamesAtLeft().toArray(Rame[]::new);
        this.rightRames = informationGame.getShip().getRamesAtRight().toArray(Rame[]::new);
    }

    public List<MoveSailor> movingStrat(int nbLeftRamesToUse, int nbRightRamesToUse, double rudderAngle){
        List<Sailor> sailorsList = Arrays.asList(sailors.clone());

        movingToGouvernail(rudderAngle, sailorsList);

        movingToVoiles(sailorsList);

        movingToRames(nbLeftRamesToUse, leftRames, nbRightRamesToUse, rightRames, sailorsList);

        for (Entities entitie : entitiesToFar) {
            movingActionsList.add(buildMovingAction(sailorsList.get(0),entitie));
            sailorsList.remove(0);
        }

        return movingActionsList;
    }

    public void movingToGouvernail(double rudderAngle, List<Sailor> sailorsList){
        Sailor sailorToMove;
        if(rudderAngle != 0){
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(gouvernail.getX(),gouvernail.getY()),sailorsList)) != null)
                movingActionsList.add(buildMovingAction(sailorToMove,gouvernail));
            else
                entitiesToFar.add(gouvernail);
        }
    }

    public void movingToVoiles(List<Sailor> sailorsList){
        Sailor sailorToMove;
        for (Voile voile : voiles) {
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(voile.getX(),voile.getY()),sailorsList)) != null){
                movingActionsList.add(buildMovingAction(sailorToMove,gouvernail));
                break;
            }
            else
                entitiesToFar.add(voile);
        }
    }

    public void movingToRames(int nbLeftRamesToUse, Rame []leftRames, int nbRightRamesToUse, Rame []rightRames, List<Sailor> sailorsList){
        Sailor sailorToMove;
        for (int i = 0; i < nbLeftRamesToUse; i++) {
            for (int j = i; j < leftRames.length; j++) {
                if((sailorToMove = nearestSailorBehind5(new PositionSailor(leftRames[j].getX(),leftRames[j].getY()),sailorsList)) != null) {
                    movingActionsList.add(buildMovingAction(sailorToMove, leftRames[j]));
                    break;
                }
                if(leftRames.length - j <= nbLeftRamesToUse - i) {
                    entitiesToFar.add(leftRames[j]);
                    break;
                }
            }
        }

        for (int i = 0; i < nbRightRamesToUse; i++) {
            for (int j = i; j < rightRames.length; j++) {
                if((sailorToMove = nearestSailorBehind5(new PositionSailor(rightRames[j].getX(),rightRames[j].getY()),sailorsList)) != null) {
                    movingActionsList.add(buildMovingAction(sailorToMove, rightRames[j]));
                    break;
                }
                if(rightRames.length - j <= nbRightRamesToUse - i) {
                    entitiesToFar.add(rightRames[j]);
                    break;
                }
            }
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

    public Sailor nearestSailorBehind5(PositionSailor placeToMove, List<Sailor> sailors){
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

    public int nbBoxBetweenSailorAndPlace(Sailor sailor, PositionSailor position2){
        return Math.abs(sailor.getX()-position2.getX()) + Math.abs(sailor.getY()-position2.getY());
    }
}
