package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
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

    List<Entities> entitiesToFar;
    List<MoveSailor> movingActionsList;
    ToolsToUse toolsToUse;
    Gouvernail gouvernail;
    Sailor []sailors;
    Voile []voiles;
    Rame []leftRames;
    Rame []rightRames;

    public MoveActionStrategie(){
    }

    public MoveActionStrategie(ToolsToUse toolsToUse, InformationGame informationGame){
        movingActionsList = new ArrayList<>();
        entitiesToFar = new ArrayList<>();

        this.toolsToUse = toolsToUse;
        this.sailors = informationGame.getSailors();
        this.gouvernail = informationGame.getShip().getGouvernail();
        this.voiles = informationGame.getShip().getVoiles().toArray(Voile[]::new);
        this.leftRames = informationGame.getShip().getRamesAtLeft().toArray(Rame[]::new);
        this.rightRames = informationGame.getShip().getRamesAtRight().toArray(Rame[]::new);
    }

    public List<MoveSailor> movingStrat(int nbLeftRames, int nbRightRames, double rudderAngle){
        List<Sailor> sailorsList = Arrays.asList(sailors.clone());

        movingToGouvernail(rudderAngle, sailorsList);

        movingToVoiles(sailorsList);

        movingToRames(nbLeftRames, nbRightRames, sailorsList);

        for (Entities entitie : entitiesToFar) {
            movingActionsList.add(buldMovingAction(sailorsList.get(0),entitie));
            sailorsList.remove(0);
        }

        return movingActionsList;
    }

    private void movingToGouvernail(double rudderAngle, List<Sailor> sailorsList){
        Sailor sailorToMove;
        if(rudderAngle != 0){
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(gouvernail.getX(),gouvernail.getY()),sailorsList)) != null)
                movingActionsList.add(buldMovingAction(sailorToMove,gouvernail));
            else
                entitiesToFar.add(gouvernail);
        }
    }

    private void movingToVoiles(List<Sailor> sailorsList){
        Sailor sailorToMove;
        for (Voile voile : voiles) {
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(voile.getX(),voile.getY()),sailorsList)) != null){
                movingActionsList.add(buldMovingAction(sailorToMove,gouvernail));
                break;
            }
            else
                entitiesToFar.add(voile);
        }
    }

    private void movingToRames(int nbLeftRames, int nbRightRames, List<Sailor> sailorsList){
        Sailor sailorToMove;
        for (int i = 0; i < nbLeftRames; i++) {
            for (int j = i; j < leftRames.length; j++) {
                if((sailorToMove = nearestSailorBehind5(new PositionSailor(leftRames[j].getX(),leftRames[j].getY()),sailorsList)) != null) {
                    movingActionsList.add(buldMovingAction(sailorToMove, leftRames[j]));
                    break;
                }
                if(leftRames.length - j <= nbLeftRames - i) {
                    entitiesToFar.add(leftRames[j]);
                    break;
                }
            }
        }

        for (int i = 0; i < nbRightRames; i++) {
            for (int j = i; j < rightRames.length; j++) {
                if((sailorToMove = nearestSailorBehind5(new PositionSailor(rightRames[j].getX(),rightRames[j].getY()),sailorsList)) != null) {
                    movingActionsList.add(buldMovingAction(sailorToMove, rightRames[j]));
                    break;
                }
                if(rightRames.length - j <= nbRightRames - i) {
                    entitiesToFar.add(rightRames[j]);
                    break;
                }
            }
        }
    }

    private MoveSailor buldMovingAction(Sailor sailor, Entities destination){
        int moveOnX = Math.min(Math.max(sailor.getX()-destination.getX(), -5), 5);
        int moveOnY = Math.min(Math.max(sailor.getY()-destination.getY(), -5), 5);

        if(Math.abs(moveOnX) + Math.abs(moveOnY) > 5) {
            if(moveOnY >= 0)
                moveOnY = (moveOnY > 1) ? moveOnY - 1 : 0;
            else
                moveOnY = moveOnY + 1;
            moveOnX = (moveOnX < 0) ? -5 + Math.abs(moveOnY) : 5 - Math.abs(moveOnY);
        }

        return new MoveSailor(moveOnX,moveOnY,sailor.getId());
    }

    private Sailor nearestSailorBehind5(PositionSailor placeToMove, List<Sailor> sailors){
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
