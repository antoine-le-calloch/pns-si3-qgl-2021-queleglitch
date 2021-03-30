package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

import java.util.Arrays;

public class Reef extends VisibleEntities{

    private final String type = "reef";

    public Reef() {
    }

    public Reef(Position position, Shape shape) {
        super(position,shape);
    }

    public Point[] getReelPointsForm(){
        return shape.getRealPoints(position);
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() {
        return type;
    }
}
