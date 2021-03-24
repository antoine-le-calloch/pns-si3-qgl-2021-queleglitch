package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Sail extends Entities {
    private boolean openned;

    public Sail(){}

    public Sail(int x, int y, boolean opened){
        super(x,y);
        this.openned = opened;
    }

    /**
     * <p>Getter.</p>
     */
    public boolean isOpenned(){
        return openned;
    }

    /**
     * <p>Setter.</p>
     */
    public void setOpenned(boolean openned) {
        this.openned = openned;
    }
}
