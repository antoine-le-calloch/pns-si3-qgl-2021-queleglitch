package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WindActionStrategieTest {

    WindActionStrategie windActionStrategie;
    Ship mockShipSailClose;
    Ship mockShipSailOpen;
    Goal goal;

    @BeforeEach
    void setUp() {
        mockShipSailClose = mock(Ship.class);
        Mockito.when(mockShipSailClose.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailClose.getVoiles()).thenReturn(Arrays.asList(new Voile[]{new Voile(0, 0, false)}.clone()));

        mockShipSailOpen = mock(Ship.class);
        Mockito.when(mockShipSailOpen.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShipSailOpen.getVoiles()).thenReturn(Arrays.asList(new Voile[]{new Voile(0, 0, true)}.clone()));
    }

    ////////////////UseWind

    @Test
    void WindResolverUseWind_PIOn3_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(Math.PI / 3)));
        assertEquals(1, windActionStrategie.windResolver());
    }
    @Test
    void WindResolverUseWind_PIOn2_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(Math.PI / 2)));
        assertEquals(1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverUseWind_2PIOn3_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(2 * Math.PI / 3)));
        assertEquals(1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverUseWind_3PIOn4_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(3 * Math.PI / 4)));
        assertEquals(1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(Math.PI / 6)));
        assertEquals(1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverUseWind_PIOn6_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind(Math.PI / 6)));
        assertEquals(0, windActionStrategie.windResolver());
    }

    ////////////////NotUseWind

    @Test
    void WindResolverNotUseWind_3PIOn2_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind(3*Math.PI / 2)));
        assertEquals(-1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverNotUseWind_5PIOn4_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind(5*Math.PI / 4)));
        assertEquals(-1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind(4 * Math.PI / 3)));
        assertEquals(-1, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverNotUseWind_4PIOn3_SailClose() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailClose), new NextRound(new Wind(4 * Math.PI / 3)));
        assertEquals(0, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_PI_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind( Math.PI )));
        assertEquals(0, windActionStrategie.windResolver());
    }

    @Test
    void WindResolverPerpendicularWind_DoNotTouch_MinusPI_SailOpen() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShipSailOpen), new NextRound(new Wind(0.0)));
        assertEquals(0, windActionStrategie.windResolver());
    }
}