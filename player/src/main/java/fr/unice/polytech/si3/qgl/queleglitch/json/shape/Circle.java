package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

import java.util.Objects;

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
        final int NB_POINTS = 100;
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

    /**
     * <p>Override of toString method, allow to print a different string to give the Circle's information</p>
     */
    @Override
    public String toString() {
        return "Radius : " + radius;
    }

    /**
     * <p>Override of equals method, allow to compare different Circle by their x, y value</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, this.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }
}
