package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;

public class ToolsToUse {
    public double rudderAngle;
    public SailAction actionOnSail;
    public NbOarsUsed nbOarsUsed;

    public ToolsToUse(double rudderAngle, SailAction actionOnSail, NbOarsUsed nbOarsUsed){
        this.rudderAngle = rudderAngle;
        this.actionOnSail = actionOnSail;
        this.nbOarsUsed = nbOarsUsed;
    }

    public double getRudderAngle() {
        return rudderAngle;
    }

    public SailAction getActionOnSail() {
        return actionOnSail;
    }

    public NbOarsUsed getNbOarsUsed() {
        return nbOarsUsed;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.rudderAngle == toolsToUse.rudderAngle &&
                this.actionOnSail == toolsToUse.actionOnSail &&
                this.nbOarsUsed.onLeft() == toolsToUse.getNbOarsUsed().onLeft() &&
                this.nbOarsUsed.onRight() == toolsToUse.getNbOarsUsed().onRight();
    }

    @Override
    public String toString(){
        return "Angle du rudder : " + this.rudderAngle + ", nb Sails : " + this.actionOnSail + ", nb left oars to use : " + this.nbOarsUsed.onLeft() + ", nb right oars to use : " + this.nbOarsUsed.onRight();
    }
}