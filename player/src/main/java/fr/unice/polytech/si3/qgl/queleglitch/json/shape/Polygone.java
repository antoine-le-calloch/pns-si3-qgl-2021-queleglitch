package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

public class Polygone extends Shape {

    private double orientation;
    private Point[] vertices;

    double positionToPoint(Point point){
        return point.getX();
    }

    public double getArea(){
        return 0;
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
}
