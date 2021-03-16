package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

import java.util.Objects;

public class Rame extends Entities{

    public Rame(int x, int y){
        super(x,y);
    }

    public Rame(){}

    @Override
    public String toString() {
        return "Rame{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Rame)) {
            return false;
        }
        Rame r = (Rame) o;
        return Double.compare(x, r.x) == 0
                && Double.compare(y, r.y) == 0;
    }
}
