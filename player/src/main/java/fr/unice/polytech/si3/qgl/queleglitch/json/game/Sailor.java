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
    public int id;
    public int x;
    public int y;

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
}
