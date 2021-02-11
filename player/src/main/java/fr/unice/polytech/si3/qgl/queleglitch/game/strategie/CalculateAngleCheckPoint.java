package fr.unice.polytech.si3.qgl.queleglitch.game.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;

public class CalculateAngleCheckPoint {
    double shipX;
    double shipY;
    double shipAngle;
    double checkPointX;
    double checkPointY;

    public CalculateAngleCheckPoint(Position shipPosition, Position checkPointPosition){
        shipX = shipPosition.getX();
        shipY = shipPosition.getY();
        shipAngle = shipPosition.getOrientation();
        checkPointX = checkPointPosition.getX();
        checkPointY = checkPointPosition.getY();
    }


}
