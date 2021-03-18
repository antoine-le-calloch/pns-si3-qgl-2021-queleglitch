package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.calcul.SmartFindNbOar;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OarStrategyTest {

    OarStrategy oarStrategy;
    SmartFindNbOar smartFindNbOar;
    int []nbRightAndLeftOar;

    @BeforeEach
    void setUp(){
        oarStrategy = new OarStrategy(new InformationGame(),2);
    }

    @Test
    void noAngleToCorrectWithOars(){
        assertEquals(0, oarStrategy.getDifferenceOarRightLeft(Math.PI/8));
    }

    @Test
    void anglePositiveToCorrectWithOars(){
        assertEquals(1, oarStrategy.getDifferenceOarRightLeft(Math.PI));
    }

    @Test
    void angleNegativeToCorrectWithOars(){
        assertEquals(-1, oarStrategy.getDifferenceOarRightLeft(-Math.PI));
    }

    ///////////

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(5,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, true);
        assertEquals(0,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(4,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, true);
        assertEquals(0,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(13,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, true);
        assertEquals(8,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(12,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, true);
        assertEquals(8,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    /////UseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(5,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, false);
        assertEquals(1,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(4,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, false);
        assertEquals(0,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(13,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, false);
        assertEquals(9,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(12,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(true, false);
        assertEquals(8,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    /////NotUseRudder_UseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(5,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, true);
        assertEquals(1,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(4,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, true);
        assertEquals(0,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(13,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, true);
        assertEquals(9,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        smartFindNbOar = new SmartFindNbOar(12,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, true);
        assertEquals(8,nbRightAndLeftOar[0]);
        assertEquals(2,nbRightAndLeftOar[1]);
    }

    /////NotUseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(5,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, false);
        assertEquals(1,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(4,20,2);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, false);
        assertEquals(1,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(13,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, false);
        assertEquals(9,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        smartFindNbOar = new SmartFindNbOar(12,20,-6);
        nbRightAndLeftOar = smartFindNbOar.getNbLeftAndRightOar(false, false);
        assertEquals(9,nbRightAndLeftOar[0]);
        assertEquals(3,nbRightAndLeftOar[1]);
    }
}