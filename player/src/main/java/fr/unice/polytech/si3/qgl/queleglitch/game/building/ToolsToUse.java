package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;

import java.util.Objects;

public class ToolsToUse {

    private final double rudderAngle;
    private final SailAction actionOnSail;
    private final NbOarsUsed nbOarsUsed;
    private final boolean isWatchNecessary;

    public ToolsToUse(double rudderAngle, SailAction actionOnSail, NbOarsUsed nbOarsUsed, boolean isWatchNecessary){
        this.rudderAngle = rudderAngle;
        this.actionOnSail = actionOnSail;
        this.nbOarsUsed = nbOarsUsed;
        this.isWatchNecessary = isWatchNecessary;
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

    public boolean getIsWatchNecessary() { return isWatchNecessary;}

    /**
     * <p>Override of toString method, allow to print a different string to give the Sailor's information</p>
     */
    @Override
    public String toString(){
        return "Angle du rudder : " + this.rudderAngle + ", nb Sails : " + this.actionOnSail + ", " + this.nbOarsUsed.toString() + ", Vigie ? : " + this.isWatchNecessary;
    }

    /**
     * <p>Override of equals method, allow to compare different ToolsToUse by their rudderAngle, actionOnSail and their nbOarUsed</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ToolsToUse)) return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.rudderAngle == toolsToUse.rudderAngle && this.actionOnSail == toolsToUse.actionOnSail && this.nbOarsUsed.equals(toolsToUse.nbOarsUsed) && this.isWatchNecessary == toolsToUse.isWatchNecessary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rudderAngle, actionOnSail, nbOarsUsed);
    }
}