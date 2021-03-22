package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;

/**
 * Classe permettant de gerer les éléments principaux du jeux : {@link Ship}, {@link Sailor}
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class InformationGame {
    public Sailor[] sailors;
    public Ship ship;
    public Goal goal;
    public Wind wind;

    public InformationGame(Sailor[] sailors, Ship ship, Goal goal){
        this.sailors = sailors;
        this.ship = ship;
        this.goal = goal;
    }

    public InformationGame(Goal goal, Ship ship, Wind wind){
        this.goal = goal;
        this.ship = ship;
        this.wind = wind;
    }

    public InformationGame(){}

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

    /**
     * @return <b>The RegattaGoal.</b>
     */
    public RegattaGoal getRegattaGoal() {
        if(goal instanceof RegattaGoal)
            return (RegattaGoal) goal;
        return null;
    }

    /**
     * @return <b>The Wind.</b>
     */
    public Wind getWind() {
        return wind;
    }

    public void setShip(Ship ship){
        this.ship = ship;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setWind(Wind wind){
        this.wind = wind;
    }

    public boolean isCheckpointReached() {
        return ship.isCheckpointReached(((RegattaGoal) goal).getActualCheckpoint());
    }

    public void moveToNextCheckpoint() {
        ((RegattaGoal) goal).checkpointReached();
    }
}
