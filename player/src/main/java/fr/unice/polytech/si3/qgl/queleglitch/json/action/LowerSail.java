package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class LowerSail extends Action{

    public String type = "LOWER_SAIL";

    public LowerSail(int sailorId) {
        super(sailorId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LowerSail)) {
            return false;
        }
        LowerSail l = (LowerSail) o;
        return sailorId== l.sailorId;
    }
}
