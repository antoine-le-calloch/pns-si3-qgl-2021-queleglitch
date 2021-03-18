package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class OarStrategy {

    private final int NB_RAMES;
    private final InformationGame informationGame;

    public OarStrategy(InformationGame informationGame) {
        this.informationGame=informationGame;
        NB_RAMES = informationGame.getShip().getRames().size();
    }

    public OarStrategy(InformationGame informationGame, int nbRames){
        this.informationGame = informationGame;
        this.NB_RAMES = nbRames;
    }

    public double getDifferenceOarRightLeftStrategy(Double angleToCorrect) {
        int signe = 1;
        if(angleToCorrect < 0)
            angleToCorrect *= (signe = -1);

        if(angleToCorrect > Math.PI / 4)
            return (int) (Math.round(Math.PI / 2 * signe/(Math.PI/ NB_RAMES)));

        return 0;
    }

    public int[] getNbLeftAndRightOar(boolean useRudder, boolean useSail, int differenceOarRightLeft) {
        int nbLeftRamesToUse = -Math.min(0,differenceOarRightLeft);
        int nbRightRamesToUse = Math.max(0,differenceOarRightLeft);
        int nbSailorsForOar = informationGame.sailors.length;

        if (useRudder)
            nbSailorsForOar--;
        if (useSail)
            nbSailorsForOar--;

        while (nbLeftRamesToUse + nbRightRamesToUse <= nbSailorsForOar - 2) {
            if(nbLeftRamesToUse >= NB_RAMES/2 || nbRightRamesToUse >= NB_RAMES/2)
                break;
            nbRightRamesToUse++;
            nbLeftRamesToUse++;
        }

        return new int[]{Math.min(nbSailorsForOar,nbLeftRamesToUse),Math.min(nbSailorsForOar,nbRightRamesToUse)};
    }
}
