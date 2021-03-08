package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

public class ToolsToUse {
    public double angleRudder;
    public double numberOfSailor;
    public double numberOfSail;

    public ToolsToUse(double angleRudder, double numberOfSailor, double numberOfSail){
        this.angleRudder = angleRudder;
        this.numberOfSailor = numberOfSailor;
        this.numberOfSail = numberOfSail;
    }

    public double getAngleRudder() {
        return angleRudder;
    }

    public double getNumberOfSail() {
        return numberOfSail;
    }

    public double getNumberOfSailor() {
        return numberOfSailor;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.angleRudder == toolsToUse.angleRudder && this.numberOfSailor == toolsToUse.numberOfSailor && this.numberOfSail == toolsToUse.numberOfSail;
    }

    @Override
    public String toString(){
        return "Rudder angle : " + this.angleRudder + ", Nb sailors : " + this.numberOfSailor + ", Nb sail : " + this.numberOfSail;
    }
}