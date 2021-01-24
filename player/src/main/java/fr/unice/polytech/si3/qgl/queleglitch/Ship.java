package fr.unice.polytech.si3.qgl.queleglitch;

public class Ship {
    public Position position;

    public Position getPosition() {
        return position;
    }

    public String getStringPosition(){
        return "Bateau | orientation : " + position.orientation +
                " | x : " + position.x + " | y : " + position.y;
    }
}
