package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.MoveSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.PositionSailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveActionStrategie {

    ToolsToUse toolsToUse;
    Sailor []sailors;
    Gouvernail gouvernail;
    Voile voile;
    List<Entities> entitiesToFar;

    public MoveActionStrategie(){
    }

    public MoveActionStrategie(ToolsToUse toolsToUse, InformationGame informationGame){
        this.toolsToUse = toolsToUse;
        this.sailors = informationGame.getSailors();
        this.gouvernail = informationGame.getShip().getGouvernail();
        //this.voile = informationGame.getShip().get;
        List<Entities> entitiesToFar = new ArrayList<>();
    }

    public List<MoveSailor> movingStrat(int nbLeftOar, int nbRightOar, double rudderAngle, int nbSailToUse){
        int nbSailorToUse = nbLeftOar+nbRightOar+nbSailToUse+(rudderAngle != 0 ? 1 : 0);
        List<MoveSailor> moveSailors = new ArrayList<>();
        List<Sailor> sailorsList = Arrays.asList(sailors.clone());
        Sailor sailorToMove;

        if(rudderAngle != 0){
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(gouvernail.getX(),gouvernail.getY()),sailorsList)) != null)
                moveSailors.add(moveSailorBuld(sailorToMove,gouvernail));
            else
                entitiesToFar.add(gouvernail);
        }

        if(nbSailToUse != 0){
            if((sailorToMove = nearestSailorBehind5(new PositionSailor(gouvernail.getX(),gouvernail.getY()),sailorsList)) != null)
                moveSailors.add(moveSailorBuld(sailorToMove,gouvernail));
            else
                entitiesToFar.add(gouvernail);
        }
        return null;
    }

    private MoveSailor moveSailorBuld(Sailor sailor, Entities destination){
        return new MoveSailor(sailor.getX()-destination.getX(),sailor.getY()-destination.getY(),sailor.getId());
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
