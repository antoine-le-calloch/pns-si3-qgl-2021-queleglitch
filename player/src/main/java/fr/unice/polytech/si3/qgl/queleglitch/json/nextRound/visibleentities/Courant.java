package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

public class Courant extends VisibleEntities{

    private final String type = "stream";
    private double strength;

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
