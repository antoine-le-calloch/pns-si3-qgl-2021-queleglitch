package fr.unice.polytech.si3.qgl.queleglitch.json.nextRound;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.Courant;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.visibleentities.VisibleEntities;

/* classe qui sert juste de variable pour mettre à jour le informationGame*/

public class NextRound {
    private Ship ship;
    private Wind wind;
    private VisibleEntities[] visibleEntities;

    public  NextRound(){}

    public VisibleEntities getCourant(){
        for (VisibleEntities visibleEntities:visibleEntities){
            if(visibleEntities instanceof Courant) {
                return (Courant) visibleEntities;
            }
        }
        return null;
    }
    
    /**
     * <p>Getter.</p>
     */
    public Ship getShip(){
        return ship;
    }

    public Wind getWind() {
        return wind;
    }

    public VisibleEntities[] getVisibleEntities() {
        return visibleEntities;
    }

    /**
     * <p>Setter.</p>
     */
    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setVisibleEntities(VisibleEntities[] visibleEntities) {
        this.visibleEntities = visibleEntities;
    }
}
