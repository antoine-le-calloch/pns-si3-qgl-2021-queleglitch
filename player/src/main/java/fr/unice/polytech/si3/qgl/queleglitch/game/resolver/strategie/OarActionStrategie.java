package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class OarActionStrategie extends Strategie {


    private final int NB_OARS;

    public OarActionStrategie(InformationGame informationGame) {
        super(informationGame);
        NB_OARS = informationGame.getShip().getRames().size();
    }

    public OarActionStrategie(InformationGame informationGame,int nb_Oars){
        super(informationGame);
        this.NB_OARS=nb_Oars;
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
        return (int) (Math.round(angleToCheckPoint/(Math.PI/NB_OARS)));
    }


}
