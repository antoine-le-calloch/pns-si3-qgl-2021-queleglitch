package fr.unice.polytech.si3.qgl.queleglitch.json.game;

public class MoveSailor {
    public int x;
    public int y;
    public int id;

    public MoveSailor(int x, int y, int id){
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public MoveSailor(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * @return <b>The id of the sailor</b>
     */
    public int getId(){
        return id;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * <p>Override of toString method, allow to print a different string to give the Sailor's informations</p>
     */
    @Override
    public String toString(){
        return "Marin " + id + " | move in x of : " + x + " | move in y of : " + y;
    }
}
