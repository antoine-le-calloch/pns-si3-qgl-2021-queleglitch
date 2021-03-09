package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class LIFT_SAIL extends Action {

    public String type = "LIFT_SAIL";

    public LIFT_SAIL(int sailorId) {
        super(sailorId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LIFT_SAIL)) {
            return false;
        }
        LIFT_SAIL l = (LIFT_SAIL) o;
        return sailorId== l.sailorId;
    }
}
