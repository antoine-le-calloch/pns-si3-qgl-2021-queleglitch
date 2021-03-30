package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

/**
 * Classe permettant de définir la forme cercledu checkpoint
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */
public class Circle extends Shape {

    private double radius;

    public Circle(){}

    public Circle(double radius){
        this.radius = radius;
    }

    public Point[] getRealPoints(Position centralPosition){
        double angle = 0;
        final int NB_POINTS = 1000;
        Point[] points = new Point[NB_POINTS];
        for(int i = 0; i < NB_POINTS; i++){
            points[i] = new Point(centralPosition.getX()+Math.cos(angle)*(radius+10),centralPosition.getY()+Math.sin(angle)*(radius+10));
            angle += 2*Math.PI/NB_POINTS;
        }
        return points;
    }

    /**
     * <p>Getter.</p>
     */
    public double getRadius(){
        return radius;
    }

    /**
     * <p>Setter.</p>
     */
    public void setRadius(double radius) { this.radius = radius; }
}
