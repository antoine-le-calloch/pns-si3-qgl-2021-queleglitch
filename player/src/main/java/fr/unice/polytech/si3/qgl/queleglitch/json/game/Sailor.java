package fr.unice.polytech.si3.qgl.queleglitch.json.game;

/**
 * Classe representant les marins
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Sailor {
    public int x;
    public int y;
    public int id;

    public Sailor(int x, int y, int id){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public Sailor(){}

    /**
     * @return <b>The id of the sailor</b>
     */
    public int getId(){
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Sailor's informations</p>
     */
    @Override
    public String toString(){
        return "Marin " + id + " | position x : " + x + " | position y : " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Sailor))
            return false;
        Sailor sailor = (Sailor) obj;
        return this.x == sailor.x &&
                this.y == sailor.y &&
                this.id == sailor.id;
    }
}