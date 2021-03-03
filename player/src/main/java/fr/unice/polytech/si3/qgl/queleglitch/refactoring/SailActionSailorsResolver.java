package fr.unice.polytech.si3.qgl.queleglitch.refactoring;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;

public class SailActionSailorsResolver extends SailorsResolver {

    public SailActionSailorsResolver(InformationGame informationGame) {
        super(informationGame);
    }

    public int oarAction(double angleToCheckPoint){

        int signe = 1;

        if(angleToCheckPoint < 0) {
            angleToCheckPoint *= (signe = -1);
        }

        if(angleToCheckPoint > 3*Math.PI / 4){
            turnWIthOar((Math.PI / 2)*signe);
        }
        else if (angleToCheckPoint > Math.PI / 4) {
            turnWIthOar((Math.PI / 2) * signe);
        }
        else if (angleToCheckPoint > 1.0 * Math.PI / 180.0) {
            if(NB_ROWER%2 == 0 && angleToCheckPoint-Math.PI / NB_OAR >= -Math.PI/4) {
                turnWIthOar(-Math.PI / NB_OAR * signe);
            }
            else {
                turnWIthOar(0.0);
                turnWIthRudder(angleToCheckPoint * signe);
            }
        }
    }


}
