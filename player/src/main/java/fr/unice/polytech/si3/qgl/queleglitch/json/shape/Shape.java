package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "rectangle"),
        @JsonSubTypes.Type(value = Polygon.class, name = "polygon")
})

/**
 * <h1>{@link Shape} :</h1>
 *
 * <p>This class provides a skeletal implementation of the {@link Circle},
 *
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @see Shape
 * @see Circle
 * @version 2021.01.26
 */
public abstract class Shape {

    public abstract Point[] getRealPoints(Position centralPosition);
}