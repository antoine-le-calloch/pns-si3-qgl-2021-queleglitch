package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding.FindPath;
import fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding.Grid;
import fr.unice.polytech.si3.qgl.queleglitch.game.pathfinding.Spotting;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.SeaEntities;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextround.Wind;

/**
 * Classe permettant de gerer les éléments principaux du jeux : {@link Ship}, {@link Sailor}
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class InformationGame {
    private final SeaEntities seaEntities;
    private Sailor[] sailors;
    private Grid grid;
    private Ship ship;
    private Goal goal;
    private Wind wind;

    public InformationGame(){
        seaEntities = new SeaEntities();
    }

    public InformationGame(Sailor[] sailors, Ship ship, Goal goal, Wind wind){
        seaEntities = new SeaEntities();
        this.sailors = sailors;
        this.ship = ship;
        this.goal = goal;
        this.wind = wind;
    }

    public InformationGame(Goal goal, Ship ship, Wind wind){
        seaEntities = new SeaEntities();
        this.goal = goal;
        this.ship = ship;
        this.wind = wind;
    }

    public void processCheckpointReached() {
        getRegattaGoal().setCheckpointReach(true);
        moveToNextCheckpoint();
        createGrid();
    }

    public void processCheckpointNotReached() {
        getRegattaGoal().setCheckpointReach(false);
    }

    public void createGrid() {
        grid = new Grid(8200,200,200);
        Spotting spotting = new Spotting(seaEntities.getVisibleReefs(),seaEntities.getVisibleStreams());
        grid.create(ship.getPosition().toPoint(), getRegattaGoal().getPositionActualOptiCheckpoint().toPoint(),spotting);
    }

    public boolean createPath() {
        Spotting spotting = new Spotting(seaEntities.getVisibleReefs(),seaEntities.getVisibleStreams());
        grid.reloadCaseInformation(spotting);
        grid.processCaseWeight(ship.getPosition().toPoint());
        FindPath findPath = new FindPath(grid);
        return findPath.createPath(getRegattaGoal(),grid.getCaseOfAPosition(ship.getPosition()));
    }

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

    public boolean checkpointOutOfGrid() {
        return grid.getCaseOfAPosition(getRegattaGoal().getPositionActualOptiCheckpoint()) == null;
    }

    /**
     * <p>Getter.</p>
     */
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
        this.seaEntities.addSeaEntities(nextRound.getVisibleEntities());
        this.ship = nextRound.getShip();
        this.wind = nextRound.getWind();
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
