package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

/**
 * Classe permettant de définir le mode Regatta
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class RegattaGoal extends Goal {

    private Checkpoint[] checkpoints;
    private Position[] positionOptiCheckpoints;
    private int numActualCheckpoint = 0;

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
        positionOptiCheckpoints[tabSize-1] = new Position(checkpoints[tabSize-1].getPosition().x,checkpoints[tabSize-1].getPosition().y,0);

        for (int i = tabSize-1; i > 0; i--) {
            angleBetween2Points = positionOptiCheckpoints[i].getAngleToAPlace(checkpoints[i-1].getPosition());
            distanceToTheNewPoints = positionOptiCheckpoints[i].getNorm(checkpoints[i-1].getPosition()) - checkpoints[i-1].getRadius();
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

    public void checkpointReached(){
        if(numActualCheckpoint + 1 < checkpoints.length){
            numActualCheckpoint++;
        }
    }

    /**
     * <p>Getter.</p>
     */
    public Position[] getPositionOptiCheckpoints() { return positionOptiCheckpoints; }

    public Checkpoint getActualCheckpoint(){ return checkpoints[numActualCheckpoint]; }

    public Position getPositionActualOptiCheckpoint(){
        return positionOptiCheckpoints[numActualCheckpoint];
    }

    public int getNumActualCheckpoint(){
        return numActualCheckpoint;
    }
    /**
     * <p>Setter.</p>
     */
    public void setCheckpoints(Checkpoint[] checkpoints) {
        this.checkpoints = checkpoints;
    }

    public void setNumActualCheckpoint(int numActualCheckpoint){ this.numActualCheckpoint = numActualCheckpoint; }

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
