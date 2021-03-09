package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;

/* classe qui sert juste de variable pour mettre à jour le informationGame*/

public class NextRound {
    public Ship ship;
    public Wind wind;

    public Ship getShip(){
        return ship;
    }

    public Wind getWind() {
        return wind;
    }

    public  NextRound(){}

    public  NextRound(Ship ship){
        this.ship = ship;
    }
}
