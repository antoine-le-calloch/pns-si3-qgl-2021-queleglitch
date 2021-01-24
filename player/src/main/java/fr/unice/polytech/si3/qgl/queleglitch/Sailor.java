package fr.unice.polytech.si3.qgl.queleglitch;

class Sailor {
    public int id;
    public int x;
    public int y;

    int getId(){
        return id;
    }

    public String getInformations(){
        return "Marin " + id + " | position x : " + x + " | position y : " + y;
    }
}
