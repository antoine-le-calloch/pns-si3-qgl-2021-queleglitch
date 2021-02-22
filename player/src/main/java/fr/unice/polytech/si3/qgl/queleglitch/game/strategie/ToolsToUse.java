package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

public class ToolsToUse {
    public double rudderAngle;
    public int nbLeftOarToUse;
    public int nbRightOarToUse;

    public ToolsToUse(){}

    public ToolsToUse(double rudderAngle, int nbLeftOarToUse, int nbRightOarToUse){
        this.rudderAngle = rudderAngle;
        this.nbLeftOarToUse = Math.max(nbLeftOarToUse, 0);
        this.nbRightOarToUse = Math.max(nbRightOarToUse, 0);
    }

    public void setToolsToUse(double rudderAngle, int nbLeftOarToUse, int nbRightOarToUse){
        this.rudderAngle = rudderAngle;
        this.nbLeftOarToUse = Math.max(nbLeftOarToUse, 0);
        this.nbRightOarToUse = Math.max(nbRightOarToUse, 0);
    }

    public void decreaseNbSailors(){
        nbLeftOarToUse--;
        nbRightOarToUse--;
    }

    public void setRudderAngle(double rudderAngle){
        this.rudderAngle = rudderAngle;
    }

    public void setNbLeftOarToUse(int nbLeftOarToUse){ this.nbLeftOarToUse = Math.max(nbLeftOarToUse, 0); }

    public void setNbRightOarToUse(int nbRightOarToUse){
        this.nbRightOarToUse = Math.max(nbRightOarToUse, 0);
    }


    public double getRudderAngle(){ return rudderAngle; }

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
        return this.nbLeftOarToUse == toolsToUse.nbLeftOarToUse && this.nbRightOarToUse == toolsToUse.nbRightOarToUse && this.rudderAngle == toolsToUse.rudderAngle;
    }

    @Override
    public String toString(){
        return "Rudder angle : " + this.rudderAngle + ", Nb left oar : " + this.nbLeftOarToUse + ", Nb right oar : " + this.nbRightOarToUse;
    }
}