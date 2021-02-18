package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

public class ToolsToUse {
    public double rudderAngle = 0;
    public int nbLeftOarToUse = 0;
    public int nbRightOarToUse = 0;

    public ToolsToUse(double rudderAngle, int nbLeftOarToUse, int nbRightOarToUse){
        this.rudderAngle = rudderAngle;
        if(nbLeftOarToUse > 0)
            this.nbLeftOarToUse = nbLeftOarToUse;

        if(nbRightOarToUse > 0)
            this.nbRightOarToUse = nbRightOarToUse;
    }

    public ToolsToUse(){}

    public void setRudderAngle(double rudderAngle){
        this.rudderAngle = rudderAngle;
    }

    public void setNbLeftOarToUse(int nbLeftOarToUse){
        this.nbLeftOarToUse = nbLeftOarToUse;
    }

    public void setNbRightOarToUse(int nbRightOarToUse){
        this.nbRightOarToUse = nbRightOarToUse;
    }

    public double getRudderAngle(){
        return rudderAngle;
    }

    public int getNbLeftOarToUse(){ return nbLeftOarToUse; }

    public int getNbRightOarToUse(){
        return nbRightOarToUse;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.nbLeftOarToUse == toolsToUse.nbLeftOarToUse && this.nbRightOarToUse == toolsToUse.nbRightOarToUse;
    }

    @Override
    public String toString(){
        return "Nb right oar : " + this.nbRightOarToUse + " Nb left oar : " + this.nbLeftOarToUse;
    }
}