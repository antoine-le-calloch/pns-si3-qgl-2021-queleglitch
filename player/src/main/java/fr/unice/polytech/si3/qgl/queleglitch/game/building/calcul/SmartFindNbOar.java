package fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul;

public class SmartFindNbOar {
    private int nbSailorsForOar;
    private final int differenceOarRightLeft;

    public SmartFindNbOar( int nbSailors, int differenceOarRightLeft) {
        this.nbSailorsForOar = nbSailors;
        this.differenceOarRightLeft = differenceOarRightLeft;
    }

    public int[] getNbLeftAndRightOar(boolean useRudder, boolean useSail) {
        int nbLeftRamesToUse = -Math.min(0,differenceOarRightLeft);
        int nbRightRamesToUse = Math.max(0,differenceOarRightLeft);

        if (useRudder)
            nbSailorsForOar--;
        if (useSail)
            nbSailorsForOar--;

        while (nbLeftRamesToUse + nbRightRamesToUse <= nbSailorsForOar - 2) {
            nbRightRamesToUse++;
            nbLeftRamesToUse++;
        }

        return new int[]{Math.min(nbSailorsForOar,nbLeftRamesToUse),Math.min(nbSailorsForOar,nbRightRamesToUse)};
    }
}
