package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

/**
 * Classe representant les Checkpoints
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Checkpoint {

    public Position position;
    public Shape shape;

    public Position getPosition(){
        return position;
    }

    public Shape getShape(){
        return shape;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Checkpoint's informations</p>
     */
    @Override
    public String toString() {
        return " | Checkpoint | x : " + position.x + " | y : " + position.y;
    }
}
