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

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class WindActionStrategieTest {

    WindActionStrategie windActionStrategie;
    Ship mockShip;
    Goal goal;

    @BeforeEach
    void setUp() {
        mockShip = mock(Ship.class);
        Mockito.when(mockShip.getPosition()).thenReturn(new Position(2, 4, Math.PI / 2));
        Mockito.when(mockShip.getVoiles()).thenReturn(Arrays.asList(new Voile[]{new Voile(0, 0, false)}.clone()));
    }

    ////////////////NotUseWind

    @Test
    void WindResolverUseWind_PIOn3() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }
    @Test
    void WindResolverUseWind_PIOn2() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 2)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }

    @Test
    void WindResolverUseWind_2PIOn3() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(2 * Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }

    @Test
    void WindResolverUseWind_3PIOn4() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(3 * Math.PI / 4)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }

    @Test
    void WindResolverUseWind_PIOn6() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 6)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }

    ////////////////NotUseWind

    @Test
    void WindResolverNotUseWind_3PIOn2() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(3*Math.PI / 2)));
        assertEquals(windActionStrategie.windResolver(), 0);
    }

    @Test
    void WindResolverNotUseWind_5PIOn4() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(5*Math.PI / 4)));
        assertEquals(windActionStrategie.windResolver(), 0);
    }

    @Test
    void WindResolverNotUseWind_PI() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind( Math.PI )));
        assertEquals(windActionStrategie.windResolver(), 0);
    }

    @Test
    void WindResolverNotUseWind_4PIOn3() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(4 * Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 0);
    }

}