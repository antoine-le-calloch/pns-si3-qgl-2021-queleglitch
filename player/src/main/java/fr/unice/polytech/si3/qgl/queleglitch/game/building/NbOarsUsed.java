package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import java.util.Objects;

public class NbOarsUsed {
    private int onLeft;
    private int onRight;

    public NbOarsUsed(int onLeft, int onRight){
        this.onLeft = onLeft;
        this.onRight = onRight;
    }

    public void increaseLeftAndRight(int nbToIncrease){
        onLeft += nbToIncrease;
        onRight += nbToIncrease;
    }

    public void decreaseLeftAndRight(int nbToDecrease){
        onLeft -= nbToDecrease;
        onRight -= nbToDecrease;
    }

    public int onLeft() {
        return onLeft;
    }

    public int onRight() {
        return onRight;
    }

    public void setOnLeft(int onLeft) {
        this.onLeft = onLeft;
    }

    public void setOnRight(int onRight) {
        this.onRight = onRight;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the NbOarsUsed information</p>
     */
    @Override
    public String toString(){
        return "nb left oars to use : " + this.onLeft + ", nb right oars to use : " + this.onRight;
    }

    /**
     * <p>Override of equals method, allow to compare different object NbOarsUsed by their left and right oar used</p>
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NbOarsUsed)) return false;
        NbOarsUsed nbOarsUsed = (NbOarsUsed) obj;
        return this.onLeft == nbOarsUsed.onLeft && this.onRight == nbOarsUsed.onRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(onLeft, onRight);
    }
}
