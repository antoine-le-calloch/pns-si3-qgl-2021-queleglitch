package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Rame;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.entitie.Voile;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShipMovementResolverTest {
    ShipMovementResolver ship2RamesMovementResolver;
    ShipMovementResolver ship4RamesMovementResolver;
    ShipMovementResolver ship6RamesMovementResolver;
    ShipMovementResolver ship10RamesMovementResolver;
    Ship mockShip2Rames1Voile;
    Ship mockShip4Rames1Voile;
    Ship mockShip6Rames1Voile;
    Ship mockShip10Rames1Voile;
    List<Voile> mockList1Voile;

    @BeforeEach
    void setUp() {
        mockShip2Rames1Voile = mock(Ship.class);
        mockShip4Rames1Voile = mock(Ship.class);
        mockShip6Rames1Voile = mock(Ship.class);
        mockShip10Rames1Voile = mock(Ship.class);

        List<Rame> mockList2Rames = mock(List.class);
        List<Rame> mockList4Rames = mock(List.class);
        List<Rame> mockList6Rames = mock(List.class);
        List<Rame> mockList10Rames = mock(List.class);
        mockList1Voile = mock(List.class);

        Mockito.when(mockShip2Rames1Voile.getRames()).thenReturn(mockList2Rames);
        Mockito.when(mockShip4Rames1Voile.getRames()).thenReturn(mockList4Rames);
        Mockito.when(mockShip6Rames1Voile.getRames()).thenReturn(mockList6Rames);
        Mockito.when(mockShip6Rames1Voile.getVoiles()).thenReturn(mockList1Voile);
        Mockito.when(mockShip10Rames1Voile.getRames()).thenReturn(mockList10Rames);
        Mockito.when(mockShip10Rames1Voile.getVoiles()).thenReturn(mockList1Voile);
        Mockito.when(mockList2Rames.size()).thenReturn(2);
        Mockito.when(mockList4Rames.size()).thenReturn(4);
        Mockito.when(mockList6Rames.size()).thenReturn(6);
        Mockito.when(mockList10Rames.size()).thenReturn(10);
        Mockito.when(mockList1Voile.size()).thenReturn(1);

        ship2RamesMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,new Wind(10,0), null);
        ship4RamesMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,new Wind(10,0), null);
        ship6RamesMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0), null);
        ship10RamesMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(10,0), null);
    }

    ////////////////////////////////////      Test de getAngle()      ////////////////////////////////////

    /////////rudder 0
    /////////more left than right

    @Test
    void Angle_Rudder0_0Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(0,new int[]{0,0});
        assertEquals(0, angle);
    }

    @Test
    void Angle_Rudder0_1Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(0,new int[]{1,1});
        assertEquals(0, angle);
    }

    @Test
    void Angle_Rudder0_1Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(0,new int[]{1,0});
        assertEquals(-Math.PI/2, angle);
    }

    @Test
    void Angle_Rudder0_2Left_1RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(0,new int[]{2,1});
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_Rudder0_3Left_1RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(0,new int[]{3,1});
        assertEquals(-2*Math.PI/6, angle);
    }
    @Test
    void Angle_Rudder0_3Left_2RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(0,new int[]{3,2});
        assertEquals(-1*Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_Rudder0_0Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(0,new int[]{0,1});
        assertEquals(Math.PI/2, angle);
    }

    @Test
    void Angle_Rudder0_1Left_2RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(0,new int[]{1,2});
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_Rudder0_2Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(0,new int[]{2,3});
        assertEquals(1*Math.PI/6, angle);
    }

    @Test
    void Angle_Rudder0_1Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(0,new int[]{1,3});
        assertEquals(2*Math.PI/6, angle);
    }

    /////////
    /////////rudder PI/6
    /////////more left than right

    @Test
    void Angle_RudderPIon6_0Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{0,0});
        assertEquals(Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{1,1});
        assertEquals(Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{1,0});
        assertEquals(-Math.PI/2+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_2Left_1RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{2,1});
        assertEquals(-Math.PI/4+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_3Left_1RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{3,1});
        assertEquals(-2*Math.PI/6+Math.PI/6, angle);
    }
    @Test
    void Angle_RudderPIon6_3Left_2RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{3,2});
        assertEquals(-1*Math.PI/6+Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon6_0Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{0,1});
        assertEquals(Math.PI/2+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_2RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{1,2});
        assertEquals(Math.PI/4+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_2Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{2,3});
        assertEquals(1*Math.PI/6+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/6,new int[]{1,3});
        assertEquals(2*Math.PI/6+Math.PI/6, angle);
    }

    /////////
    /////////rudder PI/4
    /////////more left than right

    @Test
    void Angle_RudderPIon4_0Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{0,0});
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{1,1});
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{1,0});
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_2Left_1RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{2,1});
        assertEquals(0, angle);
    }

    @Test
    void Angle_RudderPIon4_3Left_1RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{3,1});
        assertEquals(-2*Math.PI/6+Math.PI/4, angle);
    }
    @Test
    void Angle_RudderPIon4_3Left_2RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{3,2});
        assertEquals(-1*Math.PI/6+Math.PI/4, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon4_0Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{0,1});
        assertEquals(Math.PI/2+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_2RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{1,2});
        assertEquals(Math.PI/4+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_2Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{2,3});
        assertEquals(1*Math.PI/6+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(Math.PI/4,new int[]{1,3});
        assertEquals(2*Math.PI/6+Math.PI/4, angle);
    }

    /////////
    /////////rudder -PI/6
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon6_0Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{0,0});
        assertEquals(-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{1,1});
        assertEquals(-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{1,0});
        assertEquals(-Math.PI/2-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_1RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{2,1});
        assertEquals(-Math.PI/4-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_3Left_1RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{3,1});
        assertEquals(-2*Math.PI/6-Math.PI/6, angle);
    }
    @Test
    void Angle_RudderMinusPIon6_3Left_2RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{3,2});
        assertEquals(-1*Math.PI/6-Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon6_0Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{0,1});
        assertEquals(Math.PI/2-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_2RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{1,2});
        assertEquals(Math.PI/4-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{2,3});
        assertEquals(1*Math.PI/6-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/6,new int[]{1,3});
        assertEquals(2*Math.PI/6-Math.PI/6, angle);
    }

    /////////
    /////////rudder -PI/4
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon4_0Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{0,0});
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{1,1});
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_0RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{1,0});
        assertEquals(-3*Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_1RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{2,1});
        assertEquals(-Math.PI/2, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_3Left_1RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{3,1});
        assertEquals(-2*Math.PI/6-Math.PI/4, angle);
    }
    @Test
    void Angle_RudderMinusPIon4_3Left_2RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{3,2});
        assertEquals(-1*Math.PI/6-Math.PI/4, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon4_0Left_1RightOarUse() {
        double angle = ship2RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{0,1});
        assertEquals(Math.PI/2-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_2RightOarUse() {
        double angle = ship4RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{1,2});
        assertEquals(Math.PI/4-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{2,3});
        assertEquals(1*Math.PI/6-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_3RightOarUse() {
        double angle = ship6RamesMovementResolver.getAngleToTurn(-Math.PI/4,new int[]{1,3});
        assertEquals(2*Math.PI/6-Math.PI/4, angle);
    }

    ////////////////// Runner test
    @Test
    void Angle_RunnerTest() {
        double angle = ship10RamesMovementResolver.getAngleToTurn(0.0930508042072854,new int[]{5,5});
        assertEquals(0.0930508042072854, angle);
    }

    //////////////////////////////////////////    Test de speed()     //////////////////////////////////////////

    /////////
    /////////Not use Wind
    /////////

    @Test
    void speed_Wind_LowVoile_0OarsUseOn6() {
        assertEquals(0, ship6RamesMovementResolver.getSpeed(0, new int[]{0,0},0));
    }

    @Test
    void speed_Wind_LowVoile_1OarsUseOn6() {
        assertEquals(165/6.0, ship6RamesMovementResolver.getSpeed(0, new int[]{0,1},0));
        assertEquals(165/6.0, ship6RamesMovementResolver.getSpeed(0, new int[]{1,0},0));
    }

    @Test
    void speed_Wind_LowVoile_2OarsUseOn6() {
        assertEquals(165/3.0, ship6RamesMovementResolver.getSpeed(0, new int[]{1,1},0));
    }

    @Test
    void speed_Wind_LowVoile_4OarsUseOn6() {
        assertEquals(2*165/3.0, ship6RamesMovementResolver.getSpeed(0, new int[]{2,2},0));
    }

    @Test
    void speed_Wind_LowVoile_6OarsUseOn6() {
        assertEquals(165, ship6RamesMovementResolver.getSpeed(0, new int[]{3,3},0));
    }

    /////////
    /////////Use Wind
    /////////

    /////////Use wind with same angle than ship
    @Test
    void speed_Wind_SameAngle_HighVoile_0OarsUseOn6() {
        assertEquals(10, ship6RamesMovementResolver.getSpeed(1, new int[]{0,0},0));
    }

    @Test
    void speed_Wind_SameAngle_2HighVoiles_0OarsUseOn6() {
        assertEquals(20, ship6RamesMovementResolver.getSpeed(2, new int[]{0,0},0));
    }

    @Test
    void speed_Wind_SameAngle_HighVoile_6OarsUseOn6() {
        assertEquals(175, ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},0));
    }

    /////////Use wind with a different angle than ship
    @Test
    void speed_ShipPIon2_LowVoile_0OarsUseOn6() {
        assertEquals(0, ship6RamesMovementResolver.getSpeed(0, new int[]{0,0},Math.PI/2));
    }

    @Test
    void speed_ShipPIOn4_HighVoile_6OarsUseOn6() {
        assertEquals(165+10*Math.cos(Math.PI/4), ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},Math.PI/4));
    }

    @Test
    void speed_Ship3PIOn4_HighVoile_6OarsUseOn6() {
        assertEquals(165-10*Math.cos(Math.PI/4), ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},3*Math.PI/4));
    }

    @Test
    void speed_ShipMinusPIOn4_HighVoile_6OarsUseOn6() {
        assertEquals(165+10*Math.cos(Math.PI/4), ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},-Math.PI/4));
    }

    @Test
    void speed_ShipPIOn2_HighVoile_6OarsUseOn6() {
        assertEquals(165, ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},Math.PI/2));
    }

    @Test
    void speed_ShipMinusPIOn2_HighVoile_6OarsUseOn6() {
        assertEquals(165, ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},-Math.PI/2));
    }

    @Test
    void speed_ShipPI_HighVoile_6OarsUseOn6() {
        assertEquals(165-10, ship6RamesMovementResolver.getSpeed(1, new int[]{3,3},Math.PI));
    }

    @Test
    void speed_ShipMinusPIOn2_HighVoile_6OarsUseOn6_WindPIOn2() {
        ShipMovementResolver ship6RamesWindPIOn2MovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,Math.PI/2), null);
        assertEquals(165-10, ship6RamesWindPIOn2MovementResolver.getSpeed(1, new int[]{3,3},-Math.PI/2));
    }

    ////////////////// Runner test

    @Test
    void speed_RunnerTest() {
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0), null);
        assertEquals(165+50*Math.cos(1.0297442586766543), shipMovementResolver.getSpeed(1, new int[]{5,5},1.0297442586766543));
    }

    //////////////////////////////////////    Test de resolveNewPosition()     //////////////////////////////////////

    @Test
    void nextTurnPosition_0OarToUse_0Voile_0Rudder() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0), null);

        assertEquals(new Position(0,0,0),shipMovementResolver.resolveNextTurnPosition(0,0,new int[] {0,0}));
    }

    @Test
    void nextPosition_0OarToUse_1Voile_0Rudder() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0),null);

        assertEquals(new Position(50,0,0),shipMovementResolver.resolveNextTurnPosition(0,0,new int[] {0,0}));
    }

    @Test
    void nextPosition_AllOarToUse_0Voile_0Rudder() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0), null);

        assertEquals(new Position(165.0000000000003,0,0),shipMovementResolver.resolveNextTurnPosition(0,0,new int[] {5,5}));
    }

    ////////////////// Runner test

    @Test
    void rudderTestRound0() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(2852.173913043478,1978.827361563518,-1.0297442586766543));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0),null);

        assertEquals(new Position(2958.9016642451215, 1818.4806682445735, -0.9366934544693667),shipMovementResolver.resolveNextTurnPosition(0.0930508042072854,1,new int[] {5,5}));
    }

    @Test
    void rudderTestRound1() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(2958.9016642451215, 1818.4806682445735, -0.9366934544693667));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0),null);

        assertEquals(new Position(3074.2068908993306, 1661.6918931870753, -0.9366934544693667),shipMovementResolver.resolveNextTurnPosition(0.0,1,new int[] {5,5}));
    }
}