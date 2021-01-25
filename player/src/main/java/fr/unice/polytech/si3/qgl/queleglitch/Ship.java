package fr.unice.polytech.si3.qgl.queleglitch;

public class Ship {
    public Position position;

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString(){
        return "Bateau | orientation : " + position.orientation +
                " | x : " + position.x + " | y : " + position.y;
    }
}
