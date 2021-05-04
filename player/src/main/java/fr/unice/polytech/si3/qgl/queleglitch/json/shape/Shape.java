package fr.unice.polytech.si3.qgl.queleglitch.json.shape;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

import java.util.Objects;


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

    /**
     * <p>Override of equals method, allow to compare different Shape by their x, y value</p>
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shape.equals(this);
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }
}