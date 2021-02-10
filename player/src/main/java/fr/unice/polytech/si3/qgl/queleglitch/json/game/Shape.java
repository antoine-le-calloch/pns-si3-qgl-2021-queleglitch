package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Circle.class, name = "circle")
})

/**
 * <h1>{@link fr.unice.polytech.si3.qgl.queleglitch.json.game.Shape} :</h1>
 *
 * <p>This class provides a skeletal implementation of the {@link Circle},
 *
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @see fr.unice.polytech.si3.qgl.queleglitch.json.game.Shape
 * @see Circle
 * @version 2021.01.26
 */
public abstract class Shape {
}