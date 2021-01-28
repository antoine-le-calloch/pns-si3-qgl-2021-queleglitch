package fr.unice.polytech.si3.qgl.queleglitch.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.entitie.*;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Oar.class, name = "OAR"),
        @JsonSubTypes.Type(value = Moving.class, name = "MOVING"),
        @JsonSubTypes.Type(value = Turn.class, name = "TURN")
})

public abstract class Actions {
    public int sailorld;
}
