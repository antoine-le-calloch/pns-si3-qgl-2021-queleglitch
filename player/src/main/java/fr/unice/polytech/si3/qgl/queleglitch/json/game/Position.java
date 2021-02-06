package fr.unice.polytech.si3.qgl.queleglitch.json.game;

/**
 * Classe representant le système de position des bâteaux
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Position {
    public double x;
    public double y;
    public double orientation;

    /**
     * @return <b>The orientation.</b>
     */
    public double getOrientation() {
        return orientation;
    }

    /**
     * @return <b>The position : x.</b>
     */
    public double getX() {
        return x;
    }

    /**
     * @return <b>The position : y.</b>
     */
    public double getY() {
        return y;
    }
}
