package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Moving extends Action {
    public int xdistance;
    public int ydistance;

    public String type = "MOVING";

    public Moving(int sailorId,int xdistance,int ydistance) {

        super(sailorId);
        this.xdistance=xdistance;
        this.ydistance=ydistance;
    }
}
