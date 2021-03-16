package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Box;

public class Deck {
    public int width;
    public int length;

    public Deck(){}

    public Deck(int width, int length){
        this.width = width;
        this.length = length;
    }

    public Box getCentralPosition(){
        return new Box((int) Math.round(length/2.0)-1,(int) Math.round(width/2.0)-1);
    }
}
