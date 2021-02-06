package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;

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
