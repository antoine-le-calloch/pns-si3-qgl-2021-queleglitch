package fr.unice.polytech.si3.qgl.queleglitch;

import fr.unice.polytech.si3.qgl.queleglitch.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.goal.Goal;

/**
 * Classe permettant de gerer les éléments principaux du jeux : {@link Ship}, {@link Sailor}
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

class InitGame {
    public Sailor[] sailors;
    public Ship ship;
    public Goal goal;

    /**
     * @return <b>The list of sailors.</b>
     */
    Sailor getSailor(int numSailor){
        return sailors[numSailor];
    }

    /**
     * @return <b>The ship.</b>
     */
    Ship getShip() {return ship;}

    /**
     * @return <b>The Goal.</b>
     */
    public Goal getGoal() {
        return goal;
    }
}
