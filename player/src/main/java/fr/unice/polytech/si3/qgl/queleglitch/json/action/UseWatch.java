package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import java.util.Objects;

public class UseWatch extends Action{

    private static final String TYPE = "USE_WATCH";

    public UseWatch(int sailorId) {
        super(sailorId);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() { return TYPE; }

    /**
     * <p>Override of equals method, allow to compare different Turn action by their rotation</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof UseWatch)) return false;
        UseWatch oar = (UseWatch) obj;
        return sailorId == oar.sailorId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId);
    }
}
