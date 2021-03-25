package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Sail;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class SailStrategyTest {

    SailStrategy SailStrategy;
    Ship mockShipSailClose;
    Ship mockShipSailOpen;
    Goal goal;

    @BeforeEach
    void setUp() {
        mockShipSailClose = mock(Ship.class);
        Mockito.when(mockShipSailClose.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailClose.isSailsOpen()).thenReturn(false);

        mockShipSailOpen = mock(Ship.class);
        Mockito.when(mockShipSailOpen.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailOpen.isSailsOpen()).thenReturn(true);
    }

    ////////////////UseWind

    @Test
    void WindResolverUseWind_PIOn3_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,Math.PI / 3));
        assertEquals(SailAction.LIFT, SailStrategy.getSailsAction());
    }
    @Test
    void WindResolverUseWind_PIOn2_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,Math.PI / 2));
        assertEquals(SailAction.LIFT, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverUseWind_2PIOn3_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,2 * Math.PI / 3));
        assertEquals(SailAction.LIFT, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverUseWind_3PIOn4_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,3 * Math.PI / 4));
        assertEquals(SailAction.LIFT, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,Math.PI / 6));
        assertEquals(SailAction.LIFT, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1,Math.PI / 6));
        assertEquals(SailAction.DO_NOTHING, SailStrategy.getSailsAction());
    }

    ////////////////NotUseWind

    @Test
    void WindResolverNotUseWind_3PIOn2_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1,3*Math.PI / 2));
        assertEquals(SailAction.LOWER, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverNotUseWind_5PIOn4_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1,5*Math.PI / 4));
        assertEquals(SailAction.LOWER, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1,4 * Math.PI / 3));
        assertEquals(SailAction.LOWER, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailClose() {
        SailStrategy = new SailStrategy(mockShipSailClose, new Wind(1,4 * Math.PI / 3));
        assertEquals(SailAction.DO_NOTHING, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_PI_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1, Math.PI ));
        assertEquals(SailAction.DO_NOTHING, SailStrategy.getSailsAction());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_MinusPI_SailOpen() {
        SailStrategy = new SailStrategy(mockShipSailOpen, new Wind(1,0.0));
        assertEquals(SailAction.DO_NOTHING, SailStrategy.getSailsAction());
    }
}