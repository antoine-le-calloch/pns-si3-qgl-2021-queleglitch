package fr.unice.polytech.si3.qgl.queleglitch.json.entitie;

public class Voile extends Entities {
    public boolean opened;

    public Voile(int x,int y,boolean opened){
        this.x=x;
        this.y=y;
        this.opened = opened;
    }

    public Voile(){}

    public void changeVoile() {
        this.opened = !opened;
    }
}
