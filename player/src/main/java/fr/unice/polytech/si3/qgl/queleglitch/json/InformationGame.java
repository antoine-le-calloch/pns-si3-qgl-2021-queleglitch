package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding.FindPath;
import fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding.Grid;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Reef;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de gerer les éléments principaux du jeux : {@link Ship}, {@link Sailor}
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class InformationGame {
    private SeaEntities seaEntities;
    private Sailor[] sailors;
    private Grid grid;
    private Ship ship;
    private Goal goal;
    private Wind wind;

    public InformationGame(){}

    public InformationGame(Sailor[] sailors, Ship ship, Goal goal, Wind wind){
        this.sailors = sailors;
        this.ship = ship;
        this.goal = goal;
        this.wind = wind;
    }

    public InformationGame(Goal goal, Ship ship, Wind wind){
        this.goal = goal;
        this.ship = ship;
        this.wind = wind;
    }

    public void processCheckpointReached() {
        getRegattaGoal().setCheckpointReach(true);
        moveToNextCheckpoint();
        createGrid();
    }

    public void createPath() {
        FindPath findPath = new FindPath(ship.getPosition().toPoint(), seaEntities.getVisibleReefs(),grid);
        findPath.createPath(getRegattaGoal());
    }

    public void createGrid() {
        grid = new Grid();
        grid.create(ship.getPosition(), getRegattaGoal().getPositionActualOptiCheckpoint(),seaEntities);
    }

    /*public void createPath() {
        FindPath findPath = new FindPath(ship.getDeck().getWidth(), ship.getPosition().toPoint(), seaEntities.getVisibleReefs());
        if(seaEntities.getVisibleReefs() != null && seaEntities.getVisibleReefs().size() > 0)
            findPath.createPath(getRegattaGoal());
    }*/

    public boolean isCheckpointReached() {
        return ship.isCheckpointReached(getRegattaGoal().getActualCheckpoint());
    }

    public void moveToNextCheckpoint() {
        getRegattaGoal().checkpointReached();
    }

    public int getNbSailors(){
        return sailors.length;
    }

    public RegattaGoal getRegattaGoal() {
        if(goal instanceof RegattaGoal)
            return (RegattaGoal) goal;
        return null;
    }

    /**
     * <p>Getter.</p>
     */
    public SeaEntities getSeaEntities() { return seaEntities; }

    public Sailor[] getSailors(){
        return sailors;
    }

    public Ship getShip() {return ship;}

    public Goal getGoal() {
        return goal;
    }

    public Wind getWind() { return wind; }

    /**
     * <p>Setter.</p>
     */
    public void setSailors(Sailor[] sailors) { this.sailors = sailors; }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

    public void setNewRound(NextRound nextRound){
        this.seaEntities = new SeaEntities(nextRound.getVisibleEntities());
        this.ship = nextRound.getShip();
        this.wind = nextRound.getWind();
    }
}
