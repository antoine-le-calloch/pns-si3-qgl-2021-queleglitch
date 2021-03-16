package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Courant;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

/* classe qui sert juste de variable pour mettre à jour le informationGame*/

public class NextRound {
    public Ship ship;
    public Wind wind;
    public VisibleEntities[] visibleEntities;

    public Ship getShip(){
        return ship;
    }

    public Wind getWind() {
        return wind;
    }

    public VisibleEntities getCourant(){
        for (VisibleEntities visibleEntities:visibleEntities){
            if(visibleEntities instanceof Courant) {
                return (Courant) visibleEntities;
            }
        }
        return null;
    }


    public  NextRound(){}

    public  NextRound(Ship ship){
        this.ship = ship;
    }

    public  NextRound(Wind wind){
        this.wind = wind;
    }
}
