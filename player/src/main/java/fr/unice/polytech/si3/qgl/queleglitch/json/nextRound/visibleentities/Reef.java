package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

public class Reef extends VisibleEntities{

    private final String type = "reef";

    public Reef() {
    }

    public Reef(Position position, Shape shape) {
        super(position,shape);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() {
        return type;
    }
}