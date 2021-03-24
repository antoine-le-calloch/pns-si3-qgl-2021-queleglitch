package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Oar extends Action {

    private final String type = "OAR";

    public Oar(int sailorId) {
        super(sailorId);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() { return type; }

    /**
     * <p>Override of equals method, allow to compare different Turn action by their rotation</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Oar)) return false;
        Oar oar = (Oar) obj;
        return sailorId == oar.sailorId;
    }
}
