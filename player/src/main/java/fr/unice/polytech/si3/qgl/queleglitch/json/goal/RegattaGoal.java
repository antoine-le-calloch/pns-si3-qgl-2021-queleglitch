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
    public Position[] positionOptiCheckpoints;
    public int numActualCheckpoint = 2;

    public RegattaGoal(){
    }

    public RegattaGoal(Checkpoint[] checkpoints){
        this.checkpoints = checkpoints;
        calculateOptiCheckpoint();
    }

    public Position getPositionActualOptiCheckpoint(){
        return positionOptiCheckpoints[numActualCheckpoint];
    }

    public Checkpoint getActualCheckpoint(){
        return checkpoints[numActualCheckpoint];
    }

    public Position getPositionNextOptiCheckpoint(){
        if (checkpoints.length > numActualCheckpoint + 1)
            return positionOptiCheckpoints[numActualCheckpoint+1];
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
        positionOptiCheckpoints = new Position[tabSize];
        positionOptiCheckpoints[tabSize-1] = new Position(checkpoints[tabSize-1].position.x,checkpoints[tabSize-1].position.y,0);

        for (int i = tabSize-1; i > 0; i--) {
            angleBetween2Points = positionOptiCheckpoints[i].getAngleToAPlace(checkpoints[i-1].position);
            distanceToTheNewPoints = positionOptiCheckpoints[i].getNorme(checkpoints[i-1].position) - ((Circle) checkpoints[i-1].shape).radius + 25;
            positionOptiCheckpoints[i-1] = movePosition1ByPosition2(positionOptiCheckpoints[i],findHowManyToMovePosition(angleBetween2Points,distanceToTheNewPoints));
        }
    }

    public Position findHowManyToMovePosition(double angleBetween2Points, double distanceToTheNewPoints){
        double x = Math.cos(angleBetween2Points)*distanceToTheNewPoints;
        double y = Math.sin(angleBetween2Points)*distanceToTheNewPoints;
        return new Position(x,y,0);
    }

    public Position movePosition1ByPosition2(Position toMove, Position by){
        return new Position(toMove.x + by.x, toMove.y + by.y,0);
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
