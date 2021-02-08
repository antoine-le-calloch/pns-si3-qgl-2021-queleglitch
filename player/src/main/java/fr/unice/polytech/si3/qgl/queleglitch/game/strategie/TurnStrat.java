package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InitGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.action.Oar;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;

public class TurnStrat extends Strategie {
    Position shipPosition;
    Position checkPointPosition;
    MoveSailorsStrat moveSailorsStrat;

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

    public String useOar() {
        StringBuilder string = new StringBuilder();

        double angleCalculated = calculateAngle();

        if (angleCalculated <= Math.PI / 12 && angleCalculated >= -Math.PI / 12) {
            moveSailorsStrat.balancedTheSailorsOnTheRames(2, 2);
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

        // cas négatifs
        else if (angleCalculated < 0) {

            if (angleCalculated >= -Math.PI/4 && angleCalculated < -Math.PI/12) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(2, 1);
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
            } else if (angleCalculated >= -Math.PI*5/12 && angleCalculated < -Math.PI/4) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(3, 1);
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
            } else if (angleCalculated >= -Math.PI*2 && angleCalculated < -Math.PI*5/12) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(3, 0);
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
        }

        // cas positifs
        else if (angleCalculated > 0) {

            if (angleCalculated > Math.PI/12 && angleCalculated <= Math.PI/4) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(1, 2);
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
            } else if (angleCalculated > Math.PI/4 && angleCalculated <= Math.PI*5/12) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(1, 3);
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
            } else if (angleCalculated > Math.PI*5/12 && angleCalculated < Math.PI * 2) {
                moveSailorsStrat.balancedTheSailorsOnTheRames(0, 3);
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
        }




        return string.toString();

    }



        // en fonction de l'angle, ajouter certain marins qui rament
        // problème avec le début de la boucle for pour ne pas faire ramer un marin inutilement




}
