package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;

/**
 * Classe permettant de définir le mode Regatta
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class RegattaGoal extends Goal {

    public Checkpoint[] checkpoints;
    public Checkpoint[] optiCheckpoints;
    public int numActualCheckpoint = 0;

    public RegattaGoal(){}

    public RegattaGoal(Checkpoint[] checkpoints){
        this.checkpoints = checkpoints;
    }

    public Checkpoint getActualCheckpoint(){
        return checkpoints[numActualCheckpoint];
    }

    public Checkpoint getNextCheckpoint(){
        if (checkpoints.length > numActualCheckpoint + 1)
            return checkpoints[numActualCheckpoint+1];
        return null;
    }

    public void checkpointReached(){
        if(!isLastCheckpoint()){
            numActualCheckpoint++;
        }
    }

    public boolean isLastCheckpoint(){
        return numActualCheckpoint + 1 >= checkpoints.length;
    }

    public void calculateOptiCheckpoint(){
        int tabSize = checkpoints.length;
        double angleBetween2Points;
        double distanceToTheNewPoints;
        optiCheckpoints = new Checkpoint[tabSize];
        optiCheckpoints[tabSize-1] = checkpoints[tabSize-1];

        for (int i = tabSize-2; i >= 0; i--) {
            angleBetween2Points = optiCheckpoints[i].getAngleToAPlace(optiCheckpoints[i-1].position);
            distanceToTheNewPoints = optiCheckpoints[i].getDistanceToAPlace(optiCheckpoints[i-1].position) - ((Circle) optiCheckpoints[i-1].shape).radius;
            optiCheckpoints[i].position.x = Math.cos(angleBetween2Points)*distanceToTheNewPoints;
            optiCheckpoints[i].position.y = Math.sin(angleBetween2Points)*distanceToTheNewPoints;
        }
    }

    public Position findNewPosition(double angleBetween2Points, double distanceToTheNewPoints){
        double x = Math.cos(angleBetween2Points)*distanceToTheNewPoints;
        double y = Math.sin(angleBetween2Points)*distanceToTheNewPoints;
        return new Position(x,y,0);
    }


    /**
     * <p>Override of toString method, allow to print a different string to give the Checkpoints' informations</p>
     */
    @Override
    public String toString(){
        StringBuilder informationsCheckpoint = new StringBuilder();
        for(Checkpoint checkpoint : checkpoints){
            informationsCheckpoint.append(checkpoint.toString());
        }
        return informationsCheckpoint.toString();
    }
}
