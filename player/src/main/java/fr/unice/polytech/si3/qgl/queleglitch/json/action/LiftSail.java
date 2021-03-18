package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class LiftSail extends Action {

    public String type = "LIFT_SAIL";

    public LiftSail(int sailorId) {
        super(sailorId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LiftSail)) {
            return false;
        }
        LiftSail l = (LiftSail) o;
        return sailorId== l.sailorId;
    }
}
