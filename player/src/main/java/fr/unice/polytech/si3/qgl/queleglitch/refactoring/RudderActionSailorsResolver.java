package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class RudderActionSailorsResolver extends SailorsResolver {

    double rudderAngle;

    public RudderActionSailorsResolver(InformationGame informationGame) {
        super(informationGame);
        this.rudderAngle = 0;
    }

    public void setRudderAngle(double rudderAngle) {
        this.rudderAngle = Math.min(Math.max(rudderAngle, -Math.PI/4), Math.PI/4);
    }

    public double rudderAction(double angleToCheckPoint){

        int signe = 1;

        if(angleToCheckPoint < 0)
            angleToCheckPoint *= (signe = -1);

        if(angleToCheckPoint > 3*Math.PI / 4)
            return (Math.PI / 4)*signe + rudderAngle;

        else if (angleToCheckPoint > Math.PI / 4)
            return ((angleToCheckPoint - Math.PI / 2) * signe) + rudderAngle;

        else if (angleToCheckPoint > 1.0 * Math.PI / 180.0) {

            if(NB_ROWERS%2 == 0 && angleToCheckPoint-Math.PI / NB_OARS >= -Math.PI/4)
                return (angleToCheckPoint-Math.PI / NB_OARS)*signe + + rudderAngle;

            else
                return angleToCheckPoint * signe + rudderAngle;
        }
        return rudderAngle;
    }

}
