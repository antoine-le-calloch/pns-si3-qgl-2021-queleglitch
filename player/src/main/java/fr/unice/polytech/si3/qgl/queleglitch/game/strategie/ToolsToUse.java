package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

public class ToolsToUse {
    public double rudderAngle;
    public int nbLeftOar;
    public int nbRightOar;

    public ToolsToUse(double rudderAngle, int nbLeftOar, int nbRightOar){
        this.rudderAngle = rudderAngle;
        this.nbLeftOar = nbLeftOar;
        this.nbRightOar = nbRightOar;
    }

    public double getRudderAngle(){
        return rudderAngle;
    }

    public int getNbLeftOar(){
        return nbLeftOar;

    }

    public int getNbRightOar(){
        return nbRightOar;
    }
}
