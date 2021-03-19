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

    public double getAngleToAPlace(Position position){
        double adj = position.x - x;
        double opo = position.y - y;
        if(adj < 0)
            return -Math.atan(adj/opo) + (opo < 0 ? -Math.PI/2 : Math.PI/2);
        return Math.atan(opo/adj);
    }

    public Position positionNextRound(double angle,double vitesse){
        int numberOfIterations=100;
        Position newPosition=new Position(x,y,orientation);

        for(int i=0;i<numberOfIterations;i++){
            newPosition.x+=Math.cos(angle*i/numberOfIterations)*(vitesse/numberOfIterations);
            newPosition.y+=Math.sin(angle*i/numberOfIterations)*(vitesse/numberOfIterations);
            newPosition.orientation+=angle/numberOfIterations;
        }

        return newPosition;

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

    @Override
    public String toString() {
        return " | Position | x : " + x + " | y : " + y + " | orientation : " + orientation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Position))
            return false;
        Position position = (Position) obj;
        return this.x == position.x &&
                this.y == position.y &&
                this.orientation == position.orientation;
    }
}
