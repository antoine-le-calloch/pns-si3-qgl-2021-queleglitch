package fr.unice.polytech.si3.qgl.queleglitch.json.nextround.visibleentities;

import java.util.Objects;

public class Stream extends VisibleEntities{

    private static final String TYPE = "stream";
    private double strength;

    public Stream(){
        //vide
    }

    /**
     * <p>Getter.</p>
     */
    public String getType() {
        return TYPE;
    }

    public double getStrength() {
        return strength;
    }

    /**
     * <p>Setter.</p>
     */
    public void setStrength(double strength) {
        this.strength = strength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stream visibleEntities = (Stream) o;
        return this.position.equals(visibleEntities.position)
                && this.shape.equals(visibleEntities.shape);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position,shape);
    }
}
