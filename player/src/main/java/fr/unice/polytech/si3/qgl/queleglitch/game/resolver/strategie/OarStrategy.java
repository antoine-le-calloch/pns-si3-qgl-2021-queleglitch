package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class OarStrategy {

    private final int NB_RAMES;
    private final int NB_SAILORS;

    public OarStrategy(int nbSailors, int nbOars) {
        NB_RAMES = nbOars;
        NB_SAILORS = nbSailors;
    }

    public int getDifferenceOarRightLeft(Double angleToCorrect) {
        int signe = 1;
        if(angleToCorrect < 0)
            angleToCorrect *= (signe = -1);

        if(angleToCorrect > Math.PI / 4)
            return (int) (Math.round(Math.PI / 2 * signe/(Math.PI/ NB_RAMES)));

        return 0;
    }

    public NbOarsUsed getNbOarsUsed(boolean useRudder, boolean useSail, int differenceOarRightLeft) {
        int nbLeftOarsToUse = -Math.min(0,differenceOarRightLeft);
        int nbRightOarsToUse = Math.max(0,differenceOarRightLeft);
        int nbSailorsForOar = NB_SAILORS;

        nbSailorsForOar -= (useRudder) ? 1 : 0;
        nbSailorsForOar -= (useSail) ? 1 : 0;

        while (nbLeftOarsToUse + nbRightOarsToUse <= nbSailorsForOar - 2) {
            if(nbLeftOarsToUse >= NB_RAMES/2 || nbRightOarsToUse >= NB_RAMES/2)
                break;
            nbRightOarsToUse++;
            nbLeftOarsToUse++;
        }

        return new NbOarsUsed(Math.min(nbSailorsForOar,nbLeftOarsToUse),Math.min(nbSailorsForOar,nbRightOarsToUse));
    }
}
