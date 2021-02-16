package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

public class ToolsToUse {
    public double rudderAngle;
    public int nbLeftOar = 0;
    public int nbRightOar = 0;

    public ToolsToUse(int nbLeftOar, int nbRightOar){
        if(nbLeftOar > 0)
            this.nbLeftOar = nbLeftOar;

        if(nbRightOar > 0)
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