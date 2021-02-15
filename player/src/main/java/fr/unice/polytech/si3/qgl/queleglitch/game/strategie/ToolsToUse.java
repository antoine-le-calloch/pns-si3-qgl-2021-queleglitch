package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

public class ToolsToUse {
    public double rudderAngle;
    public int nbLeftOar;
    public int nbRightOar;

    public ToolsToUse(int nbLeftOar, int nbRightOar){
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.nbLeftOar == toolsToUse.nbLeftOar && this.nbRightOar == toolsToUse.nbRightOar;
    }

    @Override
    public String toString(){
        return "Nb right oar : " + this.nbRightOar + " Nb left oar : " + this.nbLeftOar;
    }
}