package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Gouvernail;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.*;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

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
    public String name;
    public Deck deck;
    public Shape shape;

    public Ship(){
    }

    public Ship(Position position){
        this.position = position;
    }

    public Ship(Position position, Entities[] entities, String name, Deck deck, Shape shape){
        this.position = position;
        this.entities = entities;
        this.name = name;
        this.deck = deck;
        this.shape = shape;
    }

    /**
     * @return <b>The position of the ship.</b>
     */
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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

    public Deck getDeck() {
        return deck;
    }

    public List<Rame> getRames(){
        List<Rame> rames=new ArrayList<>();
        for (Entities entitie:entities){
            if(entitie instanceof Rame) {
                rames.add((Rame) entitie);
            }
        }
        return rames;
    }

    public List<Voile> getVoiles(){
        List<Voile> voiles=new ArrayList<>();
        for (Entities entitie : entities){
            if(entitie instanceof Voile) {
                voiles.add((Voile) entitie);
            }
        }
        return voiles;
    }

    public Gouvernail getGouvernail(){
        for (Entities entitie:entities){
            if(entitie instanceof Gouvernail) {
                return (Gouvernail) entitie;
            }
        }
        return null;
    }

    public Box getCentralPosition(){
        return deck.getCentralPosition();
    }

    public List<Rame> getRamesAtRight(){
        return getRames().stream().filter(rame -> rame.getY()!=0).collect(Collectors.toList());
    }

    public List<Rame> getRamesAtLeft(){
        return getRames().stream().filter(rame -> rame.getY()==0).collect(Collectors.toList());
    }
}
