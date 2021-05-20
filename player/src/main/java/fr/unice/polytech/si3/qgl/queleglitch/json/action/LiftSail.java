package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import java.util.Objects;

public class LiftSail extends Action {

    private static final String TYPE = "LIFT_SAIL";

    public LiftSail(int sailorId) {
        super(sailorId);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() { return TYPE; }

    /**
     * <p>Override of equals method, allow to compare different LiftSail action by their id</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof LiftSail)) return false;
        LiftSail liftSail = (LiftSail) obj;
        return sailorId== liftSail.sailorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId);
    }
}
