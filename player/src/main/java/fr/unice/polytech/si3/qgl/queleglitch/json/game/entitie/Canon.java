package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Canon extends Entities{

    public boolean loaded;
    public double angle;

    public Canon(){}

    public Canon(int x, int y){
        super(x,y);
    }

    /**
     * <p>Getter.</p>
     */
    public boolean isLoaded() { return loaded; }

    public double getAngle() { return angle; }

    /**
     * <p>Setter.</p>
     */
    public void setLoaded(boolean loaded) { this.loaded = loaded; }

    public void setAngle(double angle) { this.angle = angle; }
}
