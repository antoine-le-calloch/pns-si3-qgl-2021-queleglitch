package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class  RudderActionResolver extends SailorsResolver {


    private final int NB_ROWERS ;
    private final int NB_OARS;

    public RudderActionResolver(InformationGame informationGame) {
        super(informationGame);
        NB_ROWERS = informationGame.getSailors().length;
        NB_OARS = informationGame.getShip().getRames().size();
    }

    public double rudderAction(double angleToCheckPoint){

        int signe = 1;

        if(angleToCheckPoint < 0) {
            angleToCheckPoint *= (signe = -1);
        }

        if(angleToCheckPoint > 3*Math.PI / 4){

            return (Math.PI / 4)*signe;
        }
        else if (angleToCheckPoint > Math.PI / 4) {

            return ((angleToCheckPoint - Math.PI / 2) * signe);
        }
        else if (angleToCheckPoint > 1.0 * Math.PI / 180.0) {
            if(NB_ROWERS%2 == 0 && angleToCheckPoint-Math.PI / NB_OARS >= -Math.PI/4) {
                return (angleToCheckPoint-Math.PI / NB_OARS)*signe;
            }
            else {
                return angleToCheckPoint * signe;
            }
        }
        return 0;
    }
}
