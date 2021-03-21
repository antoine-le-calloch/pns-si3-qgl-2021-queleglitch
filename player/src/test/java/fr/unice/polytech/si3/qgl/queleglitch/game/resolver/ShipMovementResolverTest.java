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
    ShipMovementResolver shipMovementResolver;
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
    }

    ////////////////////////////////////      Test de getAngle()      ////////////////////////////////////

    /////////rudder 0
    /////////more left than right

    @Test
    void Angle_Rudder0_0Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,0,0);
        assertEquals(0, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_1Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,1,1);
        assertEquals(0, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_1Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,1,0);
        assertEquals(-Math.PI/2, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_2Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,2,1);
        assertEquals(-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_3Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,3,1);
        assertEquals(-2*Math.PI/6, shipMovementResolver.getAngle());
    }
    @Test
    void Angle_Rudder0_3Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,3,2);
        assertEquals(-1*Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////more right than left

    @Test
    void Angle_Rudder0_0Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,0,1);
        assertEquals(Math.PI/2, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_1Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,1,2);
        assertEquals(Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_2Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,2,3);
        assertEquals(1*Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_Rudder0_1Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(0,-1,1,3);
        assertEquals(2*Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////
    /////////rudder PI/6
    /////////more left than right

    @Test
    void Angle_RudderPIon6_0Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,0,0);
        assertEquals(Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_1Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,1,1);
        assertEquals(Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_1Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,1,0);
        assertEquals(-Math.PI/2+Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_2Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,2,1);
        assertEquals(-Math.PI/4+Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_3Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,3,1);
        assertEquals(-2*Math.PI/6+Math.PI/6, shipMovementResolver.getAngle());
    }
    @Test
    void Angle_RudderPIon6_3Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,3,2);
        assertEquals(-1*Math.PI/6+Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon6_0Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,0,1);
        assertEquals(Math.PI/2+Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_1Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,1,2);
        assertEquals(Math.PI/4+Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_2Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,2,3);
        assertEquals(1*Math.PI/6+Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon6_1Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/6,-1,1,3);
        assertEquals(2*Math.PI/6+Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////
    /////////rudder PI/4
    /////////more left than right

    @Test
    void Angle_RudderPIon4_0Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,0,0);
        assertEquals(Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_1Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,1,1);
        assertEquals(Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_1Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,1,0);
        assertEquals(-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_2Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,2,1);
        assertEquals(0, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_3Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,3,1);
        assertEquals(-2*Math.PI/6+Math.PI/4, shipMovementResolver.getAngle());
    }
    @Test
    void Angle_RudderPIon4_3Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,3,2);
        assertEquals(-1*Math.PI/6+Math.PI/4, shipMovementResolver.getAngle());
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon4_0Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,0,1);
        assertEquals(Math.PI/2+Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_1Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,1,2);
        assertEquals(Math.PI/4+Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_2Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,2,3);
        assertEquals(1*Math.PI/6+Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderPIon4_1Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(Math.PI/4,-1,1,3);
        assertEquals(2*Math.PI/6+Math.PI/4, shipMovementResolver.getAngle());
    }

    /////////
    /////////rudder -PI/6
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon6_0Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,0,0);
        assertEquals(-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,1,1);
        assertEquals(-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,1,0);
        assertEquals(-Math.PI/2-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,2,1);
        assertEquals(-Math.PI/4-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_3Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,3,1);
        assertEquals(-2*Math.PI/6-Math.PI/6, shipMovementResolver.getAngle());
    }
    @Test
    void Angle_RudderMinusPIon6_3Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,3,2);
        assertEquals(-1*Math.PI/6-Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon6_0Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,0,1);
        assertEquals(Math.PI/2-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,1,2);
        assertEquals(Math.PI/4-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,2,3);
        assertEquals(1*Math.PI/6-Math.PI/6, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/6,-1,1,3);
        assertEquals(2*Math.PI/6-Math.PI/6, shipMovementResolver.getAngle());
    }

    /////////
    /////////rudder -PI/4
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon4_0Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,0,0);
        assertEquals(-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,1,1);
        assertEquals(-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_0RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,1,0);
        assertEquals(-3*Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,2,1);
        assertEquals(-Math.PI/2, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_3Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,3,1);
        assertEquals(-2*Math.PI/6-Math.PI/4, shipMovementResolver.getAngle());
    }
    @Test
    void Angle_RudderMinusPIon4_3Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,3,2);
        assertEquals(-1*Math.PI/6-Math.PI/4, shipMovementResolver.getAngle());
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon4_0Left_1RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip2Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,0,1);
        assertEquals(Math.PI/2-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_2RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip4Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,1,2);
        assertEquals(Math.PI/4-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,2,3);
        assertEquals(1*Math.PI/6-Math.PI/4, shipMovementResolver.getAngle());
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_3RightOarUse() {
        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,null);
        shipMovementResolver.setNewShipState(-Math.PI/4,-1,1,3);
        assertEquals(2*Math.PI/6-Math.PI/4, shipMovementResolver.getAngle());
    }

    ////////////////// Runner test
    @Test
    void Angle_RunnerTest() {
        shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,null);
        shipMovementResolver.setNewShipState(0.0930508042072854,-1,5,5);
        assertEquals(0.0930508042072854, shipMovementResolver.getAngle());
    }

    //////////////////////////////////////////    Test de speed()     //////////////////////////////////////////

    /////////
    /////////No Wind
    /////////

    @Test
    void speed_NoWind_LowVoile_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(0,0));
        shipMovementResolver.setNewShipState(0,-1,0,0);
        assertEquals(0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_NoWind_LowVoile_1OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(0,0));
        shipMovementResolver.setNewShipState(0,-1,0,1);
        assertEquals(165/6.0, shipMovementResolver.getSpeed());
        shipMovementResolver.setNewShipState(0,-1,1,0);
        assertEquals(165/6.0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_NoWind_LowVoile_2OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(0,0));
        shipMovementResolver.setNewShipState(0,-1,1,1);
        assertEquals(165/3.0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_NoWind_LowVoile_4OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(0,0));
        shipMovementResolver.setNewShipState(0,-1,2,2);
        assertEquals(2*165/3.0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_NoWind_LowVoile_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(0,0));
        shipMovementResolver.setNewShipState(0,-1,3,3);
        assertEquals(165, shipMovementResolver.getSpeed());
    }

    /////////
    /////////Wind
    /////////

    /////////Only wind with same angle than ship
    @Test
    void speed_Wind_SameAngle_HighVoile_NotTouch_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,0,0,0);
        assertEquals(10, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_SameAngle_HighVoile_Lift_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,1,0,0);
        assertEquals(10, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_SameAngle_HighVoile_Lower_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,-1,0,0);
        assertEquals(0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_SameAngle_LowVoile_NotTouch_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,0,0,0);
        assertEquals(0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_SameAngle_LowVoile_Lift_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,1,0,0);
        assertEquals(10, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_SameAngle_LowVoile_Lower_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,0));
        shipMovementResolver.setNewShipState(0,-1,0,0);
        assertEquals(0, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_WindPIon2_SameAngle_LowVoile_Lower_0OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI/2));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(10,Math.PI/2));
        shipMovementResolver.setNewShipState(0,-1,0,0);
        assertEquals(0, shipMovementResolver.getSpeed());
    }

    /////////wind with a different angle than ship
    @Test
    void speed_Wind_SameAngle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,0));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(185, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_PIOn4Angle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI/4));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165+20*Math.cos(Math.PI/4), shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_3PIOn4Angle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,3*Math.PI/4));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165-20*Math.cos(Math.PI/4), shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_MinusPIOn4Angle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,-Math.PI/4));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165+20*Math.cos(Math.PI/4), shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_PIOn2Angle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI/2));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_MinusPIOn2Angle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,-Math.PI/2));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_PIAngle_HighVoile_NotTouch_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(145, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_PIAngle_HighVoile_Lower_6OarsUseOn6() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,0));
        shipMovementResolver.setNewShipState(0,-1,3,3);
        assertEquals(165, shipMovementResolver.getSpeed());
    }

    @Test
    void speed_Wind_PIAngle_HighVoile_NotTouch_6OarsUseOn6_shipPIOn2() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,true));
        Mockito.when(mockShip6Rames1Voile.getPosition()).thenReturn(new Position(0,0,Math.PI));

        shipMovementResolver = new ShipMovementResolver(mockShip6Rames1Voile,new Wind(20,3*Math.PI/4));
        shipMovementResolver.setNewShipState(0,0,3,3);
        assertEquals(165+20*Math.cos(Math.PI/4), shipMovementResolver.getSpeed());
    }

    ////////////////// Runner test

    @Test
    void speed_RunnerTest() {
        Mockito.when(mockList1Voile.get(0)).thenReturn(new Voile(0,0,false));
        Mockito.when(mockShip10Rames1Voile.getPosition()).thenReturn(new Position(2852.173913043478,1978.827361563518,-1.0297442586766543));

        shipMovementResolver = new ShipMovementResolver(mockShip10Rames1Voile,new Wind(50,0));
        shipMovementResolver.setNewShipState(0.0930508042072854,1,5,5);
        assertEquals(165+50*Math.cos(1.0297442586766543), shipMovementResolver.getSpeed());
    }

}