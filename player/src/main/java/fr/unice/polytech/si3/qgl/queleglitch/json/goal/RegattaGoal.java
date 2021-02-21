package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

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
    public int numActualCheckpoint = 0;

    public RegattaGoal(){}

    public RegattaGoal(Checkpoint checkpoint, int nbCheckpoint){
        checkpoints = new Checkpoint[nbCheckpoint];
        checkpoints[0] = checkpoint;
    }

    public void setCheckpoints(Checkpoint[] checkpoints) {
        this.checkpoints = checkpoints;
        numActualCheckpoint = 0;
    }

    public void addCheckpoint(Checkpoint checkpoint, int place){
        checkpoints[place] = checkpoint;
    }

    public Checkpoint getActualCheckpoint(){
        return checkpoints[numActualCheckpoint];
    }

    public Checkpoint getNextCheckpoint(){
        return checkpoints[numActualCheckpoint+1];
    }

    public void checkpointReached(){
        if(!isLastCheckpoint()){
            numActualCheckpoint++;
        }
    }

    public boolean isLastCheckpoint(){
        return numActualCheckpoint + 1 >= checkpoints.length;
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
