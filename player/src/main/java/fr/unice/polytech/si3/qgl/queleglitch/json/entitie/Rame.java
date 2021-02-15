package fr.unice.polytech.si3.qgl.queleglitch.json.entitie;

import java.util.Objects;

public class Rame extends Entities{

    public int x;
    public int y;

    public Rame(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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
