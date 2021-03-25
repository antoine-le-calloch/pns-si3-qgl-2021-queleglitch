package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

public class Rectangle extends Shape {

    private double width;
    private double height;
    private double orientation;

    public double getRadius(){ return 0; }

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
