package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Stream.class, name = "stream"),
        @JsonSubTypes.Type(value = Reef.class, name = "reef")
})

public class VisibleEntities {

    Position position;
    Shape shape;

    public VisibleEntities() {
    }
    public VisibleEntities(Position position, Shape shape) {
        this.position = position;
        this.shape = shape;
    }

    /**
     * <p>Getter.</p>
     */
    public Position getPosition() {
        return position;
    }

    public Shape getShape() {
        return shape;
    }

    /**
     * <p>Setter.</p>
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
