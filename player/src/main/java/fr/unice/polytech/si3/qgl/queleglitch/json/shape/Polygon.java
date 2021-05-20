package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

import java.util.Arrays;
import java.util.Objects;

public class Polygon extends Shape {

    private double orientation;
    private Point[] vertices;

    public Polygon(){}

    public Polygon(double orientation, Point[] vertices){
        this.orientation = orientation;
        this.vertices = vertices;
    }

    public Point[] getRealPoints(Position centralPosition){
        double realOrientation = orientation + centralPosition.getOrientation();
        Point[] reelPoints = new Point[vertices.length];
        int cpt = 0;
        for (Point point : vertices) {
            reelPoints[cpt] = new Point(centralPosition.getX() + Math.cos(realOrientation)*point.getX() + Math.sin(-realOrientation)*point.getY(), centralPosition.getY() + Math.sin(realOrientation)*point.getX() + Math.cos(-realOrientation)*point.getY());
            cpt++;
        }
        return reelPoints;
    }

    /**
     * <p>Getter.</p>
     */
    public double getOrientation() { return orientation; }

    public Point[] getVertices() { return vertices; }

    /**
     * <p>Setter.</p>
     */
    public void setOrientation(double orientation) { this.orientation = orientation; }

    public void setVertices(Point[] vertices) { this.vertices = vertices; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Polygon's information</p>
     */
    @Override
    public String toString() {
        return "Orientation : " + orientation + " | Vertices : " + Arrays.toString(vertices);
    }

    /**
     * <p>Override of equals method, allow to compare different Polygon by their x, y value</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Double.compare(polygon.orientation, this.orientation) == 0
                && Arrays.equals(polygon.vertices, this.vertices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation,vertices);
    }
}
