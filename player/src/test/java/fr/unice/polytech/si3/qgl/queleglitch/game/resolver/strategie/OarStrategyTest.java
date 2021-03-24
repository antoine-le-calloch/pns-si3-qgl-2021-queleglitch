package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbRamesUsed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OarStrategyTest {

    OarStrategy oarStrategy;
    NbRamesUsed nbRamesUsed;

    @BeforeEach
    void setUp(){
        oarStrategy = new OarStrategy(6,2);    }

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

    ///////////getNbRamesUsed()

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, true, 2);
        assertEquals(0, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, true, 2);
        assertEquals(0, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, true, -6);
        assertEquals(8, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, true,-6);
        assertEquals(8, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    /////UseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, false,2);
        assertEquals(1, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, false,2);
        assertEquals(0, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, false,-6);
        assertEquals(9, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(true, false,-6);
        assertEquals(8, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    /////NotUseRudder_UseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, true, 2);
        assertEquals(1, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, true, 2);
        assertEquals(0, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, true, -6);
        assertEquals(9, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, true, -6);
        assertEquals(8, nbRamesUsed.onLeft());
        assertEquals(2, nbRamesUsed.onRight());
    }

    /////NotUseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, false,2);
        assertEquals(1, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, false,2);
        assertEquals(1, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, false,-6);
        assertEquals(9, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbRamesUsed = oarStrategy.getNbRamesUsed(false, false, -6);
        assertEquals(9, nbRamesUsed.onLeft());
        assertEquals(3, nbRamesUsed.onRight());
    }
}