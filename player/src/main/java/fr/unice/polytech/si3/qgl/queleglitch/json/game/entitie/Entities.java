package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rame.class, name = "oar"),
        @JsonSubTypes.Type(value = Voile.class, name = "sail"),
        @JsonSubTypes.Type(value = Gouvernail.class, name = "rudder")
        /*@JsonSubTypes.Type(value = Vigie.class, name = "watch"),
        @JsonSubTypes.Type(value = Canon.class, name = "canon")*/
})

public abstract class Entities {
    private int x;
    private int y;

    public Entities(){}

    public Entities(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * <p>Getter.</p>
     */
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * <p>Setter.</p>
     */
    public void setX(int x) { this.x = x; }

    public void setY(int y) { this.y = y; }
}
