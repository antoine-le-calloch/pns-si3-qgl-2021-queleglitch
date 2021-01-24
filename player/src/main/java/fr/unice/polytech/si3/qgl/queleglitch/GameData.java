package fr.unice.polytech.si3.qgl.queleglitch;

class GameData {
    public Sailor[] sailors;
    public Ship ship;

    Sailor getSailor(int numSailor){
        return sailors[numSailor];
    }

    Ship getShip() {return ship;}
}
