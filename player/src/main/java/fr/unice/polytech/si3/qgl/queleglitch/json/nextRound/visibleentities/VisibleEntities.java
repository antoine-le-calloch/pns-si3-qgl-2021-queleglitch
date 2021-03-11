package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Courant.class, name = "stream"),
        /*@JsonSubTypes.Type(value = Recif.class, name = "reef")*/
})

public class VisibleEntities {

    public Position position;
    public Shape shape;

    public Position getPosition() {
        return position;
    }

    public Shape getShape() {
        return shape;
    }

}
