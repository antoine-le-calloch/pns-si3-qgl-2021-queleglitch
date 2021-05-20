package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

public class Stream extends VisibleEntities{

    private final static String type = "stream";
    private double strength;

    public Stream(){}

    /**
     * <p>Getter.</p>
     */
    public String getType() {
        return type;
    }

    public double getStrength() {
        return strength;
    }

    /**
     * <p>Setter.</p>
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }
}
