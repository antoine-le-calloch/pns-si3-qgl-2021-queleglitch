package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de définir le mode Regatta
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class RegattaGoal extends Goal {

    private Position[] positionOptiCheckpoints;
    private int numActualCheckpoint = 0;
    private Checkpoint[] checkpoints;
    private boolean checkpointReach;
    private Point pathPoint;

    public RegattaGoal(){
    }

    public RegattaGoal(Checkpoint[] checkpoints){
        this.checkpoints = checkpoints;
        calculateOptiCheckpoint();
    }

    public void calculateOptiCheckpoint(){
        int tabSize = checkpoints.length;
        double angleBetween2Points;
        double distanceToTheNewPoints;
        positionOptiCheckpoints = new Position[tabSize];
        positionOptiCheckpoints[tabSize-1] = new Position(checkpoints[tabSize-1].getPosition().getX(),checkpoints[tabSize-1].getPosition().getY(),0);

        for (int i = tabSize-1; i > 0; i--) {
            angleBetween2Points = positionOptiCheckpoints[i].getAngleToAPosition(checkpoints[i-1].getPosition());
            distanceToTheNewPoints = positionOptiCheckpoints[i].getNorm(checkpoints[i-1].getPosition()) - checkpoints[i-1].getRadius() + 2;
            positionOptiCheckpoints[i-1] = findOptiCheckpoints(positionOptiCheckpoints[i],angleBetween2Points,distanceToTheNewPoints);
        }
    }

    public Position findOptiCheckpoints(Position checkpointPosition,double angleBetween2Points, double distanceToTheNewPoints){
        double x = Math.cos(angleBetween2Points)*distanceToTheNewPoints;
        double y = Math.sin(angleBetween2Points)*distanceToTheNewPoints;
        return new Position(checkpointPosition.getX() + x,checkpointPosition.getY() + y,0);
    }

    public void checkpointReached(){
        if(numActualCheckpoint + 1 < checkpoints.length)
            numActualCheckpoint++;
    }
    public void createPathPoint(Point pathPoint) { this.pathPoint = pathPoint; }

    /**
     * <p>Getter.</p>
     */
    public boolean getCheckpointReach(){ return checkpointReach; }

    public Checkpoint[] getCheckpoints() { return checkpoints; }

    public Position[] getPositionOptiCheckpoints() { return positionOptiCheckpoints; }

    public Point getPathPoint() { return pathPoint; }

    public Checkpoint getActualCheckpoint(){ return checkpoints[numActualCheckpoint]; }

    public Position getPositionActualOptiCheckpoint(){
        return positionOptiCheckpoints[numActualCheckpoint];
    }

    /**
     * <p>Setter.</p>
     */
    public void setCheckpointReach(boolean checkpointReach){ this.checkpointReach = checkpointReach; }

    public void setCheckpoints(Checkpoint[] checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void setPositionOptiCheckpoints(Position[] positionOptiCheckpoints) { this.positionOptiCheckpoints = positionOptiCheckpoints; }

    public void setNumActualCheckpoint(int numActualCheckpoint) { this.numActualCheckpoint = numActualCheckpoint; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Checkpoints information</p>
     */
    @Override
    public String toString(){
        StringBuilder informationCheckpoint = new StringBuilder();
        for(Checkpoint checkpoint : checkpoints){
            informationCheckpoint.append(checkpoint.toString());
        }
        return informationCheckpoint.toString();
    }
}
