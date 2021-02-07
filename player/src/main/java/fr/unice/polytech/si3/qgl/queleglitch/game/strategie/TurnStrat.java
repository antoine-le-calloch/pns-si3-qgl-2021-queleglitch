package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat extends Strategie {
    Position shipPosition;
    Position checkPointPosition;

    public TurnStrat(InitGame initGame) {
        super(initGame);
        checkPointPosition = ((RegattaGoal) initGame.getGoal()).getCheckpoints()[0].getPosition();
        shipPosition = initGame.getShip().getPosition();
    }

    public double calculateAngle(){
        //calculer angle bateay / checkpoint
        double shipAngle =Math.atan2(shipPosition.y, shipPosition.x);
        double checkpointAngle=Math.atan2(checkPointPosition.y, checkPointPosition.x);
        return checkpointAngle-shipAngle;
    }

    public String useOar(){
        StringBuilder string= new StringBuilder();

        // en fonction de l'angle, ajouter certain marins qui rament


        return string.toString();
    }


}
