package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;

import java.util.Objects;

public class Oar extends Action {
    public String type = "OAR";

    public Oar(int sailorId) {
        super(sailorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sailorId);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Oar)) {
            return false;
        }
        Oar r = (Oar) o;
        return sailorId == r.sailorId;
    }
}
