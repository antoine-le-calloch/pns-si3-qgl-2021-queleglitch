package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Moving extends Actions{
    public int xdistance;
    public int ydistance;

    public Moving(int sailorId,int xdistance,int ydistance) {

        super(sailorId);
        this.xdistance=xdistance;
        this.ydistance=ydistance;
    }
}
