package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe permettant de gerer les éléments principaux du jeux : {@link Ship}, {@link Sailor}
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class InitGame {
    public Sailor[] sailors;
    public Ship ship;
    public Goal goal;

    /**
     * @return <b>The list of sailors.</b>
     */
    public Sailor[] getSailors(){
        return sailors;
    }

    public List<Sailor> getSailorsAtRight(){
        List<Sailor> sailorAtRight = new ArrayList<>();
        for (Sailor sailor : sailors) {
            if(sailor.getY()==ship.deck.width-1){
                sailorAtRight.add(sailor);
            }
        }
        return sailorAtRight;
    }

    public List<Sailor> getSailorsAtLeft(){
        List<Sailor> sailorAtLeft = new ArrayList<>();
        for (Sailor sailor : sailors) {
            if(sailor.getY()==0){
                sailorAtLeft.add(sailor);
            }
        }
        return sailorAtLeft;
    }

    /**
     * @return <b>The ship.</b>
     */
    public Ship getShip() {return ship;}

    /**
     * @return <b>The Goal.</b>
     */
    public Goal getGoal() {
        return goal;
    }

    public void setShip(Ship ship){
        this.ship = ship;
    }
}
