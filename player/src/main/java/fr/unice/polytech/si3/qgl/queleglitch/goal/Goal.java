package fr.unice.polytech.si3.qgl.queleglitch.goal;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "mode", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegattaGoal.class, name = "REGATTA")
})

/**
 * <h1>{@link Goal} :</h1>
 *
 * <p>This class provides a skeletal implementation of the {@link RegattaGoal},
 *
 * @author Huot-Marchand Antoine
 * @author Naud Eric
 * @author Madern Loic
 * @author Le Calloch Antoine
 * @see Goal
 * @see RegattaGoal
 * @version 2021.01.26
 */
public abstract class Goal {
}
