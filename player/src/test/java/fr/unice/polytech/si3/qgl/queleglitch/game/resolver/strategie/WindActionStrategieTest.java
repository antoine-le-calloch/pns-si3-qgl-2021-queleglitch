package fr.unice.polytech.si3.qgl.queleglitch.game.resolver.strategie;

import fr.unice.polytech.si3.qgl.queleglitch.json.InformationGame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Goal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.NextRound;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    }

    @Test
    void WindResolverUseWindTest() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 1);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 2)));
        assertEquals(windActionStrategie.windResolver(), 1);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(2 * Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 1);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(3 * Math.PI / 4)));
        assertEquals(windActionStrategie.windResolver(), 1);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(Math.PI / 6)));
        assertEquals(windActionStrategie.windResolver(), 1);
    }

    @Test
    void WindResolverNotUseWindTest() {
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(3*Math.PI / 2)));
        assertEquals(windActionStrategie.windResolver(), 0);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(5*Math.PI / 4)));
        assertEquals(windActionStrategie.windResolver(), 0);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind( Math.PI )));
        assertEquals(windActionStrategie.windResolver(), 0);
        windActionStrategie = new WindActionStrategie(new InformationGame(goal, mockShip), new NextRound(new Wind(4 * Math.PI / 3)));
        assertEquals(windActionStrategie.windResolver(), 0);
    }

}