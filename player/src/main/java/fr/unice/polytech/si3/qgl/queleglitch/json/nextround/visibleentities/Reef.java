package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Point;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;

import java.util.Objects;

public class Reef extends VisibleEntities{

    private static final String TYPE = "reef";

    public Reef() {}

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
        return TYPE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reef visibleEntities = (Reef) o;
        return this.position.equals(visibleEntities.position)
                && this.shape.equals(visibleEntities.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position,shape);
    }

}
