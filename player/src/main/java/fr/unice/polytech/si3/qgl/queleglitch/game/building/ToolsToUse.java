package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;

public class ToolsToUse {
    public double rudderAngle;
    public VoileAction actionOnVoile;
    public NbRamesUsed nbRamesUsed;

    public ToolsToUse(double rudderAngle, VoileAction actionOnVoile, NbRamesUsed nbRamesUsed){
        this.rudderAngle = rudderAngle;
        this.actionOnVoile = actionOnVoile;
        this.nbRamesUsed = nbRamesUsed;
    }

    public double getRudderAngle() {
        return rudderAngle;
    }

    public VoileAction getActionOnVoile() {
        return actionOnVoile;
    }

    public NbRamesUsed getNbRamesUsed() {
        return nbRamesUsed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.rudderAngle == toolsToUse.rudderAngle &&
                this.actionOnVoile == toolsToUse.actionOnVoile &&
                this.nbRamesUsed.onLeft() == toolsToUse.getNbRamesUsed().onLeft() &&
                this.nbRamesUsed.onRight() == toolsToUse.getNbRamesUsed().onRight();
    }

    @Override
    public String toString(){
        return "Angle du gouvernail : " + this.rudderAngle + ", nb Voiles : " + this.actionOnVoile + ", nb left rames to use : " + this.nbRamesUsed.onLeft() + ", nb right rames to use : " + this.nbRamesUsed.onRight();
    }
}