package fr.unice.polytech.si3.qgl.queleglitch.game.building;

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
}
