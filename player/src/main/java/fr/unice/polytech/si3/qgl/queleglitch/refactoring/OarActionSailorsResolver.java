package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class OarActionSailorsResolver extends SailorsResolver {

    private final int NB_OAR;

    public OarActionSailorsResolver(InformationGame informationGame) {
        super(informationGame);
        this.NB_OAR = informationGame.getShip().getRames().size();
    }

    @Override
    public double actionResolver(Double angleToCorrect) {
        int signe = 1;

        if(angleToCorrect < 0)
            angleToCorrect *= (signe = -1);

        if(angleToCorrect > Math.PI / 4)
            return turnWIthOar(Math.PI / 2 * signe);

        return 0;
    }

    int turnWIthOar(double angleToCheckPoint){
        return (int) (Math.round(angleToCheckPoint/(Math.PI/NB_OAR)));
    }


}
