package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Moving extends Action {
    public int xdistance;
    public int ydistance;

    public String type = "MOVING";

    public Moving(int xdistance, int ydistance, int sailorId) {

        super(sailorId);
        this.xdistance=xdistance;
        this.ydistance=ydistance;
    }

    @Override
    public String toString(){
        return "Marin " + sailorId + " | move in x of : " + xdistance + " | move in y of : " + ydistance;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Moving)) {
            return false;
        }
        Moving m = (Moving) o;
        return xdistance == m.xdistance && ydistance == m.ydistance
                && sailorId== m.sailorId;
    }
}
