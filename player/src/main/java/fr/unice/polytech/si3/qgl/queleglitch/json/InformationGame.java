package fr.unice.polytech.si3.qgl.queleglitch.json;

import fr.unice.polytech.si3.qgl.queleglitch.game.pathFinding.FindPath;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Sailor;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
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
    private VisibleEntities[] visibleEntities;
    private Sailor[] sailors;
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
        FindPath findPath = new FindPath(ship.getPosition().toPoint(), getVisibleReef());
        if(isCheckpointReached())
            moveToNextCheckpoint();
        if(isPathPointReached())
            findPath.createPath(getRegattaGoal());
    }

    public boolean isCheckpointReached() {
        return ship.isCheckpointReached(getRegattaGoal().getActualCheckpoint());
    }

    public boolean isPathPointReached() {
        return getRegattaGoal().getPathPoint() != null && ship.isPathPointReached(getRegattaGoal().getPathPoint());
    }

    public void moveToNextCheckpoint() {
        ((RegattaGoal) goal).checkpointReached();
    }

    public int getNbSailors(){
        return sailors.length;
    }

    public RegattaGoal getRegattaGoal() {
        if(goal instanceof RegattaGoal)
            return (RegattaGoal) goal;
        return null;
    }

    public List<Reef> getVisibleReef() {
        List<Reef> visibleReef = new ArrayList<>();
        for (VisibleEntities visibleEntities : visibleEntities) {
            if(visibleEntities instanceof Reef)
                visibleReef.add((Reef) visibleEntities);
        }
        return visibleReef;
    }

    /**
     * <p>Getter.</p>
     */
    public VisibleEntities[] getVisibleEntities() { return visibleEntities; }

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
        this.visibleEntities = nextRound.getVisibleEntities();
        this.ship = nextRound.getShip();
        this.wind = nextRound.getWind();
    }
}
