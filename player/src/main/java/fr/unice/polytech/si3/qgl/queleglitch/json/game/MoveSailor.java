package fr.unice.polytech.si3.qgl.queleglitch.json.game;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.ToolsToUse;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Action;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Entities;

public class MoveSailor {
    public int x;
    public int y;
    public int id;
    public Action action;

    public MoveSailor(int x, int y, Action action, int id){
        this.action = action;
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
    public Action getAction(){
        return action;
    }

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof MoveSailor))
            return false;
        MoveSailor moveSailor = (MoveSailor) obj;
        return this.x == moveSailor.x &&
                this.y == moveSailor.y &&
                this.id == moveSailor.id &&
                this.action.equals(moveSailor.action);
    }
}
