package fr.unice.polytech.si3.qgl.queleglitch.json.action;

public class Turn extends Action{
    public double rotation;

    public Turn(int sailorId,double rotation) {
        super(sailorId);
        this.rotation = rotation;
    }
}
