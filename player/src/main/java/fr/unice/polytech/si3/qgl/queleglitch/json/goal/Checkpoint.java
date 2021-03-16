package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Polygone;
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

    public Checkpoint(){}

    public Checkpoint(Position position, Shape shape){
        this.position = position;
        this.shape = shape;
    }


    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Shape getShape(){
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public double getAngleToAPlace(Position position){
        double adj = position.x - this.position.x;
        double opo = position.y - this.position.y;
        if(adj < 0)
            return -Math.atan(adj/opo) + (opo < 0 ? -Math.PI/2 : Math.PI/2);
        return Math.atan(opo/adj);
    }

    public double getDistanceToAPlace(Position position){
        double adj = position.x - this.position.x;
        double opo = position.y - this.position.y;
        return Math.sqrt(Math.pow(adj,2) + Math.pow(opo,2));
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Checkpoint's informations</p>
     */
    @Override
    public String toString() {
        return " | Checkpoint | x : " + position.x + " | y : " + position.y;
    }
}
