package fr.unice.polytech.si3.qgl.queleglitch;

import fr.unice.polytech.si3.qgl.queleglitch.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.entitie.Rame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Entities[] entities;
    public Deck deck;

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

    public List<Rame> getRames(){
        List<Rame> rames=new ArrayList<>();
        for (Entities entitie:entities){
            if(entitie instanceof Rame) {
                rames.add((Rame) entitie);
            }
        }
        return new ArrayList<>(rames);
    }

    public List<Rame> getRamesAtRight(){
        return getRames().stream().filter(rame -> rame.getY()!=0).collect(Collectors.toList());
    }
    public List<Rame> getRamesAtLeft(){
        return getRames().stream().filter(rame -> rame.getY()==0).collect(Collectors.toList());
    }
}