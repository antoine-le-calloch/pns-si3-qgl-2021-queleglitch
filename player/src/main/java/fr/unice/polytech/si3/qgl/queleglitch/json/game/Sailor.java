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
    private int x;
    private int y;
    private int id;

    public Sailor(){}

    public Sailor(int x, int y, int id){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    /**
     * <p>Getter.</p>
     */
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getId(){
        return id;
    }

    /**
     * <p>Setter.</p>
     */
    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }

    public void setId(int id) { this.id = id; }

    /**
     * <p>Override of toString method, allow to print a different string to give the Sailor's information</p>
     */
    @Override
    public String toString(){
        return "Sail " + id + " | position x : " + x + " | position y : " + y;
    }

    /**
     * <p>Override of equals method, allow to compare different Sailor by their id and position</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Sailor)) return false;
        Sailor sailor = (Sailor) obj;
        return this.x == sailor.x && this.y == sailor.y && this.id == sailor.id;
    }
}