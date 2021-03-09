package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

public class Wind {

    public double orientation;
    public double strength;

    Wind(){}

    public void setWind(Wind wind){
        this.orientation = wind.orientation;
        this.strength = wind.strength;
    }
}
