package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Box;

public class Deck {
    private int width;
    private int length;

    public Deck(){}

    public Deck(int width, int length){
        this.width = width;
        this.length = length;
    }

    public Box getCentralPosition(){
        return new Box((int) Math.round(length/2.0)-1,(int) Math.round(width/2.0)-1);
    }

    /**
     * <p>Getter.</p>
     */
    public int getWidth() { return width; }

    public int getLength() { return length; }

    /**
     * <p>Setter.</p>
     */
    public void setWidth(int width) { this.width = width; }

    public void setLength(int length) { this.length = length; }
}
