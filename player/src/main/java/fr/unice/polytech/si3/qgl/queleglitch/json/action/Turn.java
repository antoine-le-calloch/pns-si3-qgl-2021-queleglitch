package fr.unice.polytech.si3.qgl.queleglitch.json.action;


import java.util.Objects;

public class Turn extends Action{

    private final String type = "TURN";
    private double rotation;

    public Turn(double rotation, int sailorId) {
        super(sailorId);
        this.rotation = rotation;
    }

    /**
     * <p>Getter.</p>
     */
    public double getRotation() {
        return rotation;
    }

    public String getType() {
        return type;
    }

    /**
     * <p>Setter.</p>
     */
    public void setRotation(double rotation) { this.rotation = rotation; }

    /**
     * <p>Override of equals method, allow to compare different Turn action by their rotation</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Turn)) return false;
        Turn turn = (Turn) obj;
        return this.rotation == turn.rotation && sailorId == turn.sailorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rotation, sailorId);
    }
}
