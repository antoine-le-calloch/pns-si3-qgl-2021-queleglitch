package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class Rectangle extends Shape {

    private double width;
    private double height;
    private double orientation;

    public Rectangle(){}

    public Rectangle(double width, double height, double orientation){
        this.width = width;
        this.height = height;
        this.orientation = orientation;
    }

    public double getRadius(){ return 0; }

    public Point[] getRealPoints(Position centralPosition){
        double realOrientation = orientation + centralPosition.getOrientation();
        Point[] reelPoints = new Point[4];
        reelPoints[0] = new Point(centralPosition.getX() + Math.cos(realOrientation)*(height/2) + Math.sin(-realOrientation)*(width/2), centralPosition.getY() + Math.sin(realOrientation)*(height/2) + Math.cos(-realOrientation)*(width/2));
        reelPoints[1] = new Point(centralPosition.getX() + Math.cos(realOrientation)*(-height/2) + Math.sin(-realOrientation)*(width/2), centralPosition.getY() + Math.sin(realOrientation)*(-height/2) + Math.cos(-realOrientation)*(width/2));
        reelPoints[2] = new Point(centralPosition.getX() + Math.cos(realOrientation)*(-height/2) + Math.sin(-realOrientation)*(-width/2), centralPosition.getY() + Math.sin(realOrientation)*(-height/2) + Math.cos(-realOrientation)*(-width/2));
        reelPoints[3] = new Point(centralPosition.getX() + Math.cos(realOrientation)*(height/2) + Math.sin(-realOrientation)*(-width/2), centralPosition.getY() + Math.sin(realOrientation)*(height/2) + Math.cos(-realOrientation)*(-width/2));
        return reelPoints;
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
}
