package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class RudderActionSailorsResolver extends SailorsResolver {

    double rudderAngle;

    public RudderActionSailorsResolver(InformationGame informationGame) {
        super(informationGame);
        this.rudderAngle = 0;
    }

    @Override
    public double actionResolver(Double angleToCorrect) {
        int signe = 1;
        if (angleToCorrect < 0) {
            angleToCorrect *= (signe = -1);
        }

        if (angleToCorrect > Math.PI / 4) {
            return Math.min(Math.max((angleToCorrect-Math.PI / 2) * signe, -Math.PI/4), Math.PI/4);
        }

        return angleToCorrect * signe;
    }

}
