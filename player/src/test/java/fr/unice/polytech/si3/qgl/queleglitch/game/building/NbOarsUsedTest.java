package fr.unice.polytech.si3.qgl.queleglitch.game.building;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NbOarsUsedTest {


    NbOarsUsed nbOarsUsed;
    int initialNumberLeft=2;
    int initialNumberRight=2;
    final int SHIFT=1;

    @BeforeEach
    void setUp(){
        nbOarsUsed = new NbOarsUsed(initialNumberLeft,initialNumberLeft);
    }

    @Test
    void increasingNumbersOfOarsOfOne(){

        nbOarsUsed.increaseLeftAndRight(SHIFT);
        assertEquals(initialNumberLeft+SHIFT,nbOarsUsed.onLeft());
        assertEquals(initialNumberLeft+SHIFT,nbOarsUsed.onRight());
    }

    @Test
    void decreasingNumbersOfOarsOfOne(){
        nbOarsUsed.decreaseLeftAndRight(SHIFT);
        assertEquals(initialNumberLeft-SHIFT,nbOarsUsed.onLeft());
        assertEquals(initialNumberLeft-SHIFT,nbOarsUsed.onRight());
    }

    @Test
    void setNbOarsAtLeft(){
        nbOarsUsed.setOnLeft(SHIFT);
        assertNotEquals(SHIFT,nbOarsUsed.onRight());
        assertEquals(SHIFT,nbOarsUsed.onLeft());
    }

    @Test
    void setNbOarsAtRight(){
        nbOarsUsed.setOnRight(SHIFT);
        assertNotEquals(SHIFT,nbOarsUsed.onLeft());
        assertEquals(SHIFT,nbOarsUsed.onRight());
    }




}