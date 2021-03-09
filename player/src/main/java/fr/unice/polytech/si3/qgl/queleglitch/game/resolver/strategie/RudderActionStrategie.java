package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class RudderActionStrategie extends Strategie {

    double rudderAngle;

    public RudderActionStrategie(InformationGame informationGame) {
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
            angleToCorrect = angleToCorrect-Math.PI/2;
        }

        if(angleToCorrect < 3*Math.PI / 180 && angleToCorrect > -3*Math.PI / 180)
            return 0;

        return Math.min(Math.max(angleToCorrect*signe, -Math.PI/4), Math.PI/4);
    }

}
