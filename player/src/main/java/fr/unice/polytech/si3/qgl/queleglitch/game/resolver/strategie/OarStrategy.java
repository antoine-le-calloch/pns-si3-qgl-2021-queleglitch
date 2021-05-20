package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;

public class OarStrategy {

    private final int NB_OARS;
    private final int NB_SAILORS;

    public OarStrategy(int nbSailors, int nbOars) {
        NB_OARS = nbOars;
        NB_SAILORS = nbSailors;
    }

    public int getDifferenceOarRightLeft(double angleToCorrect, double rudderAngle) {
        int signe = 1;
        if(angleToCorrect < 3*Math.PI / 180 && angleToCorrect > -3*Math.PI / 180)
            return 0;
        if(angleToCorrect < 0)
            angleToCorrect *= (signe = -1);

        double angleUnit = Math.PI / NB_OARS;
        double possibleAngle = angleUnit/2;
        int oarDifference = 0;
        if(rudderAngle == 0) {
            while (possibleAngle < angleToCorrect && possibleAngle < Math.PI/2){
                possibleAngle += angleUnit;
                oarDifference++;
            }
            return oarDifference*signe;
        }
        else if(angleToCorrect > Math.PI/4)
            return (int) (Math.round(Math.PI / 2 * signe/(Math.PI/ NB_OARS)));

        return 0;
    }

    public NbOarsUsed getNbOarsUsed(boolean useWatch, boolean useRudder, boolean useSail, int differenceOarRightLeft) {
        int nbLeftOarsToUse = -Math.min(0,differenceOarRightLeft);
        int nbRightOarsToUse = Math.max(0,differenceOarRightLeft);
        int nbSailorsForOar = NB_SAILORS;

        nbSailorsForOar -= (useWatch) ? 1 : 0;
        nbSailorsForOar -= (useRudder) ? 1 : 0;
        nbSailorsForOar -= (useSail) ? 1 : 0;

        while (nbLeftOarsToUse + nbRightOarsToUse <= nbSailorsForOar - 2) {
            if(nbLeftOarsToUse >= NB_OARS /2 || nbRightOarsToUse >= NB_OARS /2)
                break;
            nbRightOarsToUse++;
            nbLeftOarsToUse++;
        }

        return new NbOarsUsed(Math.min(nbSailorsForOar,nbLeftOarsToUse),Math.min(nbSailorsForOar,nbRightOarsToUse));
    }
}
