package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Oar.class, name = "OAR"),
        @JsonSubTypes.Type(value = Moving.class, name = "MOVING"),
        @JsonSubTypes.Type(value = Turn.class, name = "TURN"),
        @JsonSubTypes.Type(value = LIFT_SAIL.class, name = "LIFT_SAIL"),
        @JsonSubTypes.Type(value = LOWER_SAIL.class, name = "LOWER_SAIL"),
})

public abstract class Action {
    public int sailorId;

    public String type;

    Action(int sailorId){
        this.sailorId = sailorId;
    }
}