package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import java.util.Objects;

public class Rectangle extends Shape {

    private double width;
    private double height;
    private double orientation;
    private Point[] points;

    public Rectangle(){}

    public Rectangle(double width, double height, double orientation){
        this.width = width;
        this.height = height;
        this.orientation = orientation;
    }

    public Point[] getRealPoints(Position centralPosition){
        createPoints();
        double realOrientation = orientation + centralPosition.getOrientation();
        Point[] reelPoints = new Point[4];
        int cpt = 0;
        for (Point point : points) {
            reelPoints[cpt] = new Point(centralPosition.getX() + Math.cos(realOrientation)*point.getX() + Math.sin(-realOrientation)*point.getY(), centralPosition.getY() + Math.sin(realOrientation)*point.getX() + Math.cos(-realOrientation)*point.getY());
            cpt++;
        }
        return reelPoints;
    }

    public Point[] getRealPoints(Point centralPoint){
        createPoints();
        Point[] reelPoints = new Point[4];
        int cpt = 0;
        for (Point point : points) {
            reelPoints[cpt] = new Point(centralPoint.getX() + Math.cos(orientation)*point.getX() + Math.sin(-orientation)*point.getY(), centralPoint.getY() + Math.sin(orientation)*point.getX() + Math.cos(-orientation)*point.getY());
            cpt++;
        }
        return reelPoints;
    }

    private void createPoints(){
        points = new Point[]{new Point(height/2,width/2),new Point(-height/2,width/2),
                             new Point(-height/2,-width/2),new Point(height/2,-width/2)};
    }

    /**
     * <p>Getter.</p>
     */
    public double getWidth() { return width; }

    public double getHeight() { return height; }

    public double getOrientation() { return orientation; }

    /**
     * <p>Setter.</p>
     */
    public void setWidth(double width) { this.width = width; }

    public void setHeight(double height) { this.height = height; }

    public void setOrientation(double orientation) { this.orientation = orientation; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Rectangle's information</p>
     */
    @Override
    public String toString() {
        return "Orientation : " + orientation + " | width : " + width + " | height : " + height;
    }

    /**
     * <p>Override of equals method, allow to compare different Rectangle by their x, y value</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.orientation, this.orientation) == 0
                && Double.compare(rectangle.width, this.width) == 0
                && Double.compare(rectangle.height, this.height) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orientation,width,height);
    }
}
