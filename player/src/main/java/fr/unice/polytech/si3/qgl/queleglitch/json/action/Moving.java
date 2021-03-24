package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Moving extends Action {

    private final String type = "MOVING";
    private int xdistance;
    private int ydistance;

    public Moving(int xdistance, int ydistance, int sailorId) {
        super(sailorId);
        this.xdistance = xdistance;
        this.ydistance = ydistance;
    }

    /**
     * <p>Getter.</p>
     */
    public int getXdistance() {
        return xdistance;
    }

    public int getYdistance() {
        return ydistance;
    }

    public String getType() {
        return type;
    }

    /**
     * <p>Setter.</p>
     */
    public void setXdistance(int xdistance) {
        this.xdistance = xdistance;
    }

    public void setYdistance(int ydistance) {
        this.ydistance = ydistance;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Moving action's information</p>
     */
    @Override
    public String toString(){
        return "Marin " + sailorId + " | move in x of : " + xdistance + " | move in y of : " + ydistance;
    }

    /**
     * <p>Override of equals method, allow to compare different Moving action by their id and their distance to move</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Moving)) return false;
        Moving moving = (Moving) obj;
        return xdistance == moving.xdistance && ydistance == moving.ydistance && sailorId== moving.sailorId;
    }
}
