package fr.unice.polytech.si3.qgl.queleglitch.entitie;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import fr.unice.polytech.si3.qgl.queleglitch.entitie.Rame;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Rame.class, name = "oar"),
        @JsonSubTypes.Type(value = Voile.class, name = "sail"),
        @JsonSubTypes.Type(value = Gouvernail.class, name = "rudder"),
        @JsonSubTypes.Type(value = Vigie.class, name = "watch"),
        @JsonSubTypes.Type(value = Canon.class, name = "canon")
})

public abstract class Entities {
    public int x;
    public int y;
}
