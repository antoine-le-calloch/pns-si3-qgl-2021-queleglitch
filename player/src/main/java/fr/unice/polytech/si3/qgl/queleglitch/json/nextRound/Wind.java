package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

public class Wind {

    public double orientation;
    public double strength;

    public Wind(){}

    public Wind(double strength, double orientation){
        this.orientation=orientation;
        this.strength = strength;
    }
}
