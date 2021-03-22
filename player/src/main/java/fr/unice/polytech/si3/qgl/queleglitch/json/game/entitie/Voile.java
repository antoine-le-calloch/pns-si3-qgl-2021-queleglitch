package fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie;

public class Voile extends Entities {
    public boolean openned;

    public Voile(int x,int y,boolean opened){
        this.x=x;
        this.y=y;
        this.openned = opened;
    }

    public Voile(){}

    public boolean getOpenned(){
        return openned;
    }
}
