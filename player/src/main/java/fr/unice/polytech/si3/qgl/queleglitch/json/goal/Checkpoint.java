package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

import java.util.Objects;

/**
 * Classe representant les Checkpoints
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Checkpoint {

    private Position position;
    private Shape shape;

    public Checkpoint(){}

    public Checkpoint(Position position, Shape shape){
        this.position = position;
        this.shape = shape;
    }

    /**
     * @return <b>The radius of the circle checkpoint.</b>
     */
    public double getRadius() {
        if(shape instanceof Circle)
            return ((Circle) shape).getRadius();
        return -1;
    }

    /**
     * <p>Getter.</p>
     */
    public Position getPosition(){
        return position;
    }

    public Shape getShape(){
        return shape;
    }

    /**
     * <p>Setter.</p>
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Checkpoint)) return false;
        Checkpoint that = (Checkpoint) o;
        return Objects.equals(position, that.position) &&
                Objects.equals(shape, that.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, shape);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Checkpoint information</p>
     */
    @Override
    public String toString() {
        return " | Checkpoint | x : " + position.getX() + " | y : " + position.getY();
    }
}
