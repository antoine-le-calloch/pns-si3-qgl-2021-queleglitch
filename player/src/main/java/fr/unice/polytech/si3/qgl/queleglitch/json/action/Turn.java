package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.MoveSailor;

public class Turn extends Action{
    public double rotation;
    public String type = "TURN";

    public Turn(double rotation, int sailorId) {
        super(sailorId);
        this.rotation = rotation;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Turn))
            return false;
        Turn turn = (Turn) obj;
        return this.rotation == turn.rotation;
    }
}
