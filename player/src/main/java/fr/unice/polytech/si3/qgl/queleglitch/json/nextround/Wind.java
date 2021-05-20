package fr.unice.polytech.si3.qgl.queleglitch.json.nextround;

public class Wind {

    private double orientation;
    private double strength;

    public Wind(){}

    public Wind(double strength, double orientation){
        this.orientation=orientation;
        this.strength = strength;
    }

    /**
     * <p>Getter.</p>
     */
    public double getOrientation() {
        return orientation;
    }

    public double getStrength() {
        return strength;
    }

    /**
     * <p>Setter.</p>
     */
    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }
}
