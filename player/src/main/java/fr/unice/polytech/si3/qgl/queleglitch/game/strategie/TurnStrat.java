package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat extends Strategie {
    Position shipPosition;
    Position checkPointPosition;
    MoveSailorsStrat moveSailorsStrat;


    public TurnStrat(InitGame initGame,NextRound nextRound) {
        super(initGame);
        checkPointPosition = ((RegattaGoal) initGame.getGoal()).getCheckpoints()[0].getPosition();
        shipPosition = nextRound.ship.position;
    }

    public double calculateAngle(){
        //calculer angle bateay / checkpoint
        double shipAngle =Math.atan2(shipPosition.y, shipPosition.x);
        double checkpointAngle=Math.atan2(checkPointPosition.y, checkPointPosition.x);
        return checkpointAngle-shipAngle;
    }

    // en fonction de l'angle, ajouter certain marins qui rament
    public String useOar() {
        StringBuilder string = new StringBuilder();

        double angleCalculated = calculateAngle();

        if (angleCalculated <= Math.PI / 12 && angleCalculated >= -Math.PI / 12) {
            moveSailorsStrat.moveSailorsOnTheRames(2, 2);
            return use4Rames(string);
        }

        // cas négatifs
        else if (angleCalculated < 0) {

            if (angleCalculated >= -Math.PI/4 && angleCalculated < -Math.PI/12) {
                moveSailorsStrat.moveSailorsOnTheRames(2, 1);
                return use3Rames(string);
            } else if (angleCalculated >= -Math.PI*5/12 && angleCalculated < -Math.PI/4) {
                moveSailorsStrat.moveSailorsOnTheRames(3, 1);
                return use4Rames(string);
            } else if (angleCalculated >= -Math.PI*2 && angleCalculated < -Math.PI*5/12) {
                moveSailorsStrat.moveSailorsOnTheRames(3, 0);
                return use3Rames(string);
            }
        }

        // cas positifs
        else if (angleCalculated > 0) {

            if (angleCalculated > Math.PI/12 && angleCalculated <= Math.PI/4) {
                moveSailorsStrat.moveSailorsOnTheRames(1, 2);
                return use3Rames(string);
            } else if (angleCalculated > Math.PI/4 && angleCalculated <= Math.PI*5/12) {
                moveSailorsStrat.moveSailorsOnTheRames(1, 3);
                return use4Rames(string);
            } else if (angleCalculated > Math.PI*5/12 && angleCalculated < Math.PI * 2) {
                moveSailorsStrat.moveSailorsOnTheRames(0, 3);
                return use3Rames(string);
            }
        }




        return string.toString();

    }

    private String use3Rames(StringBuilder string) {
        for (int i = 0; i < moveSailorsStrat.sailors.length - 1; i++) {
            try {
                string.append(objectMapper.writeValueAsString(new Oar(moveSailorsStrat.sailors[i].id)));
                if (i != moveSailorsStrat.sailors.length - 2) {
                    string.append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return string.toString();
    }

    private String use4Rames(StringBuilder string) {
        for (int i = 0; i < moveSailorsStrat.sailors.length; i++) {
            try {
                string.append(objectMapper.writeValueAsString(new Oar(moveSailorsStrat.sailors[i].id)));
                if (i != moveSailorsStrat.sailors.length - 1) {
                    string.append(",");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return string.toString();
    }


        // problème avec le début de la boucle for pour ne pas faire ramer un marin inutilement
}
