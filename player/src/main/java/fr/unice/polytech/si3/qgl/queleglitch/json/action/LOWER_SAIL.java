package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class LOWER_SAIL extends Action{

    public String type = "LOWER_SAIL";

    public LOWER_SAIL(int sailorId) {
        super(sailorId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LOWER_SAIL)) {
            return false;
        }
        LOWER_SAIL l = (LOWER_SAIL) o;
        return sailorId== l.sailorId;
    }
}
