package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class LiftSail extends Action {

    private final String type = "LIFT_SAIL";

    public LiftSail(int sailorId) {
        super(sailorId);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() { return type; }

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
}
