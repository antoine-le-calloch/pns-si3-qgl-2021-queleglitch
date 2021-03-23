package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Rame extends Entities{

    public Rame(){}

    public Rame(int x, int y){
        super(x,y);
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Rame information</p>
     */
    @Override
    public String toString() {
        return "Rame{" + "x=" + getX() + ", y=" + getY() + '}';
    }

    /**
     * <p>Override of equals method, allow to compare different Rames by their position</p>
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Rame)) return false;
        Rame r = (Rame) o;
        return Double.compare(getX(), r.getX()) == 0 && Double.compare(getY(), r.getY()) == 0;
    }
}
