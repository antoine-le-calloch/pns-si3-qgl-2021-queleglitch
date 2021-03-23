package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Voile extends Entities {
    private boolean openned;

    public Voile(){}

    public Voile(int x,int y,boolean opened){
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
