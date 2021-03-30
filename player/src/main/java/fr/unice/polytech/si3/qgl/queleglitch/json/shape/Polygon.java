package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

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
}
