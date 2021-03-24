package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import java.util.Objects;

/**
 * Classe representant le système de position des bâteaux
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Position {
    private double x;
    private double y;
    private double orientation;

    public Position(){}

    public Position(double x, double y, double orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Position copyOf(){
        return new Position(x,y,orientation);
    }

    public double getNorm(Position position){
        double distance;
        distance = Math.pow(x-position.getX(),2);
        distance += Math.pow(y-position.getY(),2);
        distance = Math.sqrt(distance);
        return distance;
    }

    public double getAngleToAPlace(Position position){
        double adj = position.x - x;
        double opo = position.y - y;
        if(adj < 0)
            return -Math.atan(adj/opo) + (opo < 0 ? -Math.PI/2 : Math.PI/2);
        return Math.atan(opo/adj);
    }

    public Position calculateNewPosition(double angle, double speed){
        Position nextPosition = new Position(x,y,orientation);
        nextPosition.x += Math.cos(nextPosition.orientation)*speed;
        nextPosition.y += Math.sin(nextPosition.orientation)*speed;
        nextPosition.orientation += angle;
        return nextPosition;
    }

    /**
     * <p>Getter.</p>
     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getOrientation() {
        return orientation;
    }

    /**
     * <p>Setter.</p>
     */
    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

    public void setOrientation(double orientation) { this.orientation = orientation; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Position's information</p>
     */
    @Override
    public String toString() {
        return " | Position | x : " + x + " | y : " + y + " | orientation : " + orientation;
    }

    /**
     * <p>Override of equals method, allow to compare different Position by their x, y and their orientation</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;
        Position position = (Position) obj;
        return this.x == position.x && this.y == position.y && this.orientation == position.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y,orientation);
    }
}
