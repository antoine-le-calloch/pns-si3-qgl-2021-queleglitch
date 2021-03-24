package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.*;

import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
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
    private Position position;
    private Entities[] entities;
    private String name;
    private Deck deck;
    private Shape shape;

    public Ship(){
    }

    public Ship(Position position, Entities[] entities, String name, Deck deck, Shape shape){
        this.position = position;
        this.entities = entities;
        this.name = name;
        this.deck = deck;
        this.shape = shape;
    }

    public boolean isCheckpointReached(Checkpoint checkpoint){
        return checkpoint.getPosition().getNorm(position) < checkpoint.getRadius();
    }

    public Box getCentralPosition(){ return deck.getCentralPosition(); }

    public List<Oar> getOarsAtRight(){ return getOars().stream().filter(oar -> oar.getY()!=0).collect(Collectors.toList()); }

    public List<Oar> getOarsAtLeft(){ return getOars().stream().filter(oar -> oar.getY()==0).collect(Collectors.toList()); }

    public boolean isSailsOpen(){
        for (Entities entity : entities)
            if(entity instanceof Sail)
                return ((Sail) entity).isOpenned();
        return false;
    }

    public int getNbSails(){
        int nbSails = 0;
        for (Entities entity : entities)
            if(entity instanceof Sail)
                nbSails++;
        return nbSails;
    }

    public int getNbOars(){
        int nbOars = 0;
        for (Entities entity : entities)
            if(entity instanceof Oar)
                nbOars++;
        return nbOars;
    }

    public List<Oar> getOars(){
        List<Oar> oars =new ArrayList<>();
        for (Entities entity:entities)
            if(entity instanceof Oar)
                oars.add((Oar) entity);
        return oars;
    }

    public List<Sail> getSails(){
        List<Sail> sails = new ArrayList<>();
        for (Entities entity : entities)
            if(entity instanceof Sail)
                sails.add((Sail) entity);
        return sails;
    }

    public Rudder getRudder(){
        for (Entities entitie:entities)
            if(entitie instanceof Rudder)
                return (Rudder) entitie;
        return null;
    }

    /**
     * <p>Getter.</p>
     */
    public Position getPosition() {
        return position;
    }

    public Entities[] getEntities() {
        return entities;
    }

    public String getName() { return name; }

    public Deck getDeck() { return deck; }

    public Shape getShape() { return shape; }

    /**
     * <p>Setter.</p>
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setEntities(Entities[] entities) { this.entities = entities; }

    public void setName(String name) { this.name = name; }

    public void setDeck(Deck deck) { this.deck = deck; }

    public void setShape(Shape shape) { this.shape = shape; }
}
