package fr.unice.polytech.si3.qgl.queleglitch.game.building;

public class ToolsToUse {
    public double rudderAngle;
    public int actionOnVoiles;
    public int nbLeftRamesToUse;
    public int nbRightRamesToUse;

    public ToolsToUse(double rudderAngle, int actionOnVoiles, int nbLeftRamesToUse, int nbRightRamesToUse){
        this.rudderAngle = rudderAngle;
        this.actionOnVoiles = actionOnVoiles;
        this.nbLeftRamesToUse = nbLeftRamesToUse;
        this.nbRightRamesToUse = nbRightRamesToUse;
    }

    //angle we are going to turn using the elements given by this object
    public double angle(){
        return rudderAngle + (nbRightRamesToUse - nbLeftRamesToUse);
    }

    //speed we are going to have using the elements given by this object
    public double speed(int nbRames){
        return 165.0*(nbLeftRamesToUse+nbRightRamesToUse)/nbRames;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.rudderAngle == toolsToUse.rudderAngle &&
                this.actionOnVoiles == toolsToUse.actionOnVoiles &&
                this.nbLeftRamesToUse == toolsToUse.nbLeftRamesToUse &&
                this.nbRightRamesToUse == toolsToUse.nbRightRamesToUse;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString(){
        return "Rudder angle : " + this.rudderAngle + ", nb sail : " + this.actionOnVoiles + ", nb left oar to use : " + this.nbLeftRamesToUse + ", nb left oar to use : " + this.nbRightRamesToUse;
    }
}