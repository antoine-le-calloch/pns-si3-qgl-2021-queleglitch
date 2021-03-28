package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = Void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Courant.class, name = "stream"),
        @JsonSubTypes.Type(value = Reef.class, name = "reef")
})

public class VisibleEntities {

    private Position position;
    private Shape shape;

    public VisibleEntities() {
    }
    public VisibleEntities(Position position, Shape shape) {
        this.position = position;
        this.shape = shape;
    }

    public boolean isCircle(){
        return shape instanceof Circle;
    }

    public Point[] getReelPointsForm(){
        if(shape instanceof Rectangle)
            return ((Rectangle) shape).getReelPoints(position);
        if(shape instanceof Polygon)
            return ((Polygon) shape).getReelPoints(position);
        return null;
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
