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

    public Point[] getReelPoints(Position centralPosition){
        Point[] reelPoints = new Point[vertices.length];
        int cpt = 0;
        for (Point point : vertices) {
            reelPoints[cpt] = new Point(centralPosition.getX() + Math.cos(orientation)*point.getX() + Math.sin(-orientation)*point.getY(), centralPosition.getY() + Math.sin(orientation)*point.getX() + Math.cos(-orientation)*point.getY());
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
