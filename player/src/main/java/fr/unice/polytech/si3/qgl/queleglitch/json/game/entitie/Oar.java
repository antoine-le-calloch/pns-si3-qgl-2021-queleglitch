package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Oar extends Entities{

    public Oar(){}

    public Oar(int x, int y){
        super(x,y);
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Oar's information</p>
     */
    @Override
    public String toString() {
        return "Oar{" + "x=" + getX() + ", y=" + getY() + '}';
    }

    /**
     * <p>Override of equals method, allow to compare different Oars by their position</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Oar)) return false;
        Oar oar = (Oar) obj;
        return this.x == oar.x && this.y == oar.y;
    }
}
