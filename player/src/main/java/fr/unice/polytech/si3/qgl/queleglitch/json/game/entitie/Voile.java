package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Voile extends Entities {
    public boolean openned;

    public Voile(int x,int y,boolean openned){
        this.x=x;
        this.y=y;
        this.openned=openned;
    }

    public Voile(){

    }

    public void setOpenned(boolean openned) {
        this.openned = openned;
    }
}
