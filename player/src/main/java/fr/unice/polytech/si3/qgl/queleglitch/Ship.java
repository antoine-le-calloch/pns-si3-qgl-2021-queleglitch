package fr.unice.polytech.si3.qgl.queleglitch;

import fr.unice.polytech.si3.qgl.queleglitch.entitie.Entities;

/**
 * Classe representant les bâteaux
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @version 2021.01.26
 */

public class Ship {
    public Position position;
    public Deck deck;
    public Entities[] entities;

    /**
     * @return <b>The position of the ship.</b>
     */
    public Position getPosition() {
        return position;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Ship's informations</p>
     */
    @Override
    public String toString(){
        return "Bateau | orientation : " + position.orientation +
                " | x : " + position.x + " | y : " + position.y;
    }

    public Entities[] getEntities() {
        return entities;
    }
}
