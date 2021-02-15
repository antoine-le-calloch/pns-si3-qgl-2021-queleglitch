package fr.unice.polytech.si3.qgl.queleglitch.json.game;

/**
 * Classe representant le système de position des bâteaux
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Position {
    public double x;
    public double y;
    public double orientation;

    public Position(double x, double y, double orientation){
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public Position(){

    }

    public double getNorme(Position position){
        double distance;

        distance = Math.pow(x-position.getX(),2);
        distance += Math.pow(y-position.getY(),2);
        distance = Math.sqrt(distance);
        return distance;
    }

    /**
     * @return <b>The orientation.</b>
     */
    public double getOrientation() {
        return orientation;
    }

    /**
     * @return <b>The position : x.</b>
     */
    public double getX() {
        return x;
    }

    /**
     * @return <b>The position : y.</b>
     */
    public double getY() {
        return y;
    }
}
