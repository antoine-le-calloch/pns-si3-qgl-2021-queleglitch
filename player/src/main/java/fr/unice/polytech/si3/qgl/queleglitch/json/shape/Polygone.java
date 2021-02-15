package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

public class Polygone extends Shape {

    public double orientation;
    public Point[] vertices;

    double positionToPoint(Point point){
        return point.getX();
    }

    public double getArea(){
        return 0;
    }

}
