package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OarStrategyTest {

    OarStrategy oarStrategy;
    NbOarsUsed nbOarsUsed;

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

    ///////////getNbOarsUsed()

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, true, 2);
        assertEquals(0, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, true, 2);
        assertEquals(0, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, true, -6);
        assertEquals(8, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_UseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, true,-6);
        assertEquals(8, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    /////UseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, false,2);
        assertEquals(1, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, false,2);
        assertEquals(0, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, false,-6);
        assertEquals(9, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_UseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(true, false,-6);
        assertEquals(8, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    /////NotUseRudder_UseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, true, 2);
        assertEquals(1, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, true, 2);
        assertEquals(0, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, true, -6);
        assertEquals(9, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_UseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, true, -6);
        assertEquals(8, nbOarsUsed.onLeft());
        assertEquals(2, nbOarsUsed.onRight());
    }

    /////NotUseRudder_NotUseSail

    @Test
    void NbOarBySide_5Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(5,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, false,2);
        assertEquals(1, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_4Sailors_2MoreOnRight_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(4,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, false,2);
        assertEquals(1, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_13Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(13,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, false,-6);
        assertEquals(9, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }

    @Test
    void NbOarBySide_12Sailors_6MoreOnLeft_NotUseRudder_NotUseSail(){
        oarStrategy = new OarStrategy(12,20);
        nbOarsUsed = oarStrategy.getNbOarsUsed(false, false, -6);
        assertEquals(9, nbOarsUsed.onLeft());
        assertEquals(3, nbOarsUsed.onRight());
    }
}