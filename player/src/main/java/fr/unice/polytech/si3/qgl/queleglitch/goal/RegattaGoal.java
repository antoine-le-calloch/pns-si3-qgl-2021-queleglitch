package fr.unice.polytech.si3.qgl.queleglitch.goal;

import fr.unice.polytech.si3.qgl.queleglitch.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.goal.Goal;

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


    public Checkpoint[] getCheckpoints(){
        return checkpoints;
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
