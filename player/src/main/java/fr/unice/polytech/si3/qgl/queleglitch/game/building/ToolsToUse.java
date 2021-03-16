package fr.unice.polytech.si3.qgl.queleglitch.game.building;

public class ToolsToUse {
    public double angleRudder;
    public int moreSailorsOnTheRightThanOnTheLeft;
    public int numberOfSail;
    public int numberOfSailorMaxBeforeSlowDown;

    public ToolsToUse(double angleRudder, int moreSailorsOnTheRightThanOnTheLeft, int numberOfSail, int numberOfSailorMaxBeforeSlowDown){
        this.angleRudder = angleRudder;
        this.moreSailorsOnTheRightThanOnTheLeft = moreSailorsOnTheRightThanOnTheLeft;
        this.numberOfSail = numberOfSail;
        this.numberOfSailorMaxBeforeSlowDown = numberOfSailorMaxBeforeSlowDown;
    }

    public double getAngleRudder() {
        return angleRudder;
    }

    public double getNumberOfSailor() {
        return moreSailorsOnTheRightThanOnTheLeft;
    }

    public int getNumberOfSailorMaxBeforeSlowDown() {
        return numberOfSailorMaxBeforeSlowDown;
    }

    public int getNumberOfSail() {
        return numberOfSail;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof ToolsToUse))
            return false;
        ToolsToUse toolsToUse = (ToolsToUse) obj;
        return this.angleRudder == toolsToUse.angleRudder &&
                this.moreSailorsOnTheRightThanOnTheLeft == toolsToUse.moreSailorsOnTheRightThanOnTheLeft &&
                this.numberOfSail == toolsToUse.numberOfSail &&
                this.numberOfSailorMaxBeforeSlowDown == toolsToUse.numberOfSailorMaxBeforeSlowDown;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString(){
        return "Rudder angle : " + this.angleRudder + ", Nb sailors : " + this.moreSailorsOnTheRightThanOnTheLeft + ", Nb sail : " + this.numberOfSail;
    }
}