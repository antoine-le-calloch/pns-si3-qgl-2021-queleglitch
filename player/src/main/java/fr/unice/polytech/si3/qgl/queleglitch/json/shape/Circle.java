package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

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
