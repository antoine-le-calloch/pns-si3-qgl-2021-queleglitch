package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.VoileAction;

public class ToolsToUse {
    public double rudderAngle;
    public VoileAction actionOnVoile;
    public int[] tabNbLeftAndRightOar;

    public ToolsToUse(double rudderAngle, VoileAction actionOnVoile, int[] tabNbLeftAndRightOar){
        this.rudderAngle = rudderAngle;
        this.actionOnVoile = actionOnVoile;
        this.tabNbLeftAndRightOar = tabNbLeftAndRightOar;
    }

    public double getRudderAngle() {
        return rudderAngle;
    }

    public VoileAction getActionOnVoile() {
        return actionOnVoile;
    }

    public int[] getTabNbLeftAndRightOar() {
        return tabNbLeftAndRightOar;
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
                this.tabNbLeftAndRightOar[0] == toolsToUse.tabNbLeftAndRightOar[0] &&
                this.tabNbLeftAndRightOar[1] == toolsToUse.tabNbLeftAndRightOar[1];
    }

    @Override
    public String toString(){
        return "Angle du gouvernail : " + this.rudderAngle + ", nb Voiles : " + this.actionOnVoile + ", nb left rames to use : " + this.tabNbLeftAndRightOar[0] + ", nb right rames to use : " + this.tabNbLeftAndRightOar[1];
    }
}