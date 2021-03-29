package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

import java.util.Objects;

public class Point {

    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getNorm(Point point){
        double distance;
        distance = Math.pow(x-point.getX(),2);
        distance += Math.pow(y-point.getY(),2);
        distance = Math.sqrt(distance);
        return distance;
    }

    public double getAngleToAPoint(Point point){
        double adj = point.getX() - x;
        double opo = point.getY() - y;
        if(adj < 0)
            return -Math.atan(adj/opo) + (opo < 0 ? -Math.PI/2 : Math.PI/2);
        return Math.atan(opo/adj);
    }

    /**
     * <p>Getter.</p>
     */
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    /**
     * <p>Setter.</p>
     */
    public void setX(double x) { this.x = x; }

    public void setY(double y) { this.y = y; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Point's information</p>
     */
    @Override
    public String toString() {
        return "Point{" + "x=" + x + ", y=" + y + '}';
    }

    /**
     * <p>Override of equals method, allow to compare different Point by their x, y value</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
