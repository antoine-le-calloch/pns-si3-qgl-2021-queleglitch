package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import java.util.Objects;

public class LowerSail extends Action{

    private final String type = "LOWER_SAIL";

    public LowerSail(int sailorId) {
        super(sailorId);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() { return type; }

    /**
     * <p>Override of equals method, allow to compare different LowerSail action by their id</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof LowerSail)) return false;
        LowerSail lowerSail = (LowerSail) obj;
        return sailorId== lowerSail.sailorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId);
    }
}
