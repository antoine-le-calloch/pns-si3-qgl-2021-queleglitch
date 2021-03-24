package fr.unice.polytech.si3.qgl.queleglitch.json.action;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property =  "type", defaultImpl = void.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Oar.class, name = "OAR"),
        @JsonSubTypes.Type(value = Moving.class, name = "MOVING"),
        @JsonSubTypes.Type(value = Turn.class, name = "TURN"),
        @JsonSubTypes.Type(value = LiftSail.class, name = "LIFT_SAIL"),
        @JsonSubTypes.Type(value = LowerSail.class, name = "LOWER_SAIL"),
})

public abstract class Action {

    int sailorId;

    Action(int sailorId){
        this.sailorId = sailorId;
    }

    /**
     * <p>Getter.</p>
     */
    public int getSailorId() {
        return sailorId;
    }

    /**
     * <p>Setter.</p>
     */
    public void setSailorId(int sailorId) {
        this.sailorId = sailorId;
    }
}