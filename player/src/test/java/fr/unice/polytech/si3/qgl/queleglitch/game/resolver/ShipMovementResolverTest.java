package fr.unice.polytech.si3.qgl.queleglitch.game.resolver;

import fr.unice.polytech.si3.qgl.queleglitch.enums.SailAction;
import fr.unice.polytech.si3.qgl.queleglitch.game.building.NbOarsUsed;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.game.Ship;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.Checkpoint;
import fr.unice.polytech.si3.qgl.queleglitch.json.goal.RegattaGoal;
import fr.unice.polytech.si3.qgl.queleglitch.json.nextRound.Wind;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ShipMovementResolverTest {
    ShipMovementResolver ship2OarsMovementResolver;
    ShipMovementResolver ship4OarsMovementResolver;
    ShipMovementResolver ship6OarsMovementResolver;
    ShipMovementResolver ship10OarsMovementResolver;
    Ship mockShip2Oars1Sail;
    Ship mockShip4Oars1Sail;
    Ship mockShip6Oars1Sail;
    Ship mockShip10Oars1Sail;

    @BeforeEach
    void setUp() {
        mockShip2Oars1Sail = mock(Ship.class);
        mockShip4Oars1Sail = mock(Ship.class);
        mockShip6Oars1Sail = mock(Ship.class);
        mockShip10Oars1Sail = mock(Ship.class);

        Mockito.when(mockShip2Oars1Sail.getNbOars()).thenReturn(2);
        Mockito.when(mockShip4Oars1Sail.getNbOars()).thenReturn(4);
        Mockito.when(mockShip6Oars1Sail.getNbOars()).thenReturn(6);
        Mockito.when(mockShip6Oars1Sail.getNbSails()).thenReturn(1);
        Mockito.when(mockShip10Oars1Sail.getNbOars()).thenReturn(10);
        Mockito.when(mockShip10Oars1Sail.getNbSails()).thenReturn(1);

        ship2OarsMovementResolver = new ShipMovementResolver(mockShip2Oars1Sail,new Wind(10,0), null);
        ship4OarsMovementResolver = new ShipMovementResolver(mockShip4Oars1Sail,new Wind(10,0), null);
        ship6OarsMovementResolver = new ShipMovementResolver(mockShip6Oars1Sail,new Wind(10,0), null);
        ship10OarsMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(10,0), null);
    }

    ////////////////////////////////////      Test de getAngle()      ////////////////////////////////////

    /////////rudder 0
    /////////more left than right

    @Test
    void Angle_Rudder0_0Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(0,0));
        assertEquals(0, angle);
    }

    @Test
    void Angle_Rudder0_1Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(1,1));
        assertEquals(0, angle);
    }

    @Test
    void Angle_Rudder0_1Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(1,0));
        assertEquals(-Math.PI/2, angle);
    }

    @Test
    void Angle_Rudder0_2Left_1RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(2,1));
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_Rudder0_3Left_1RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(3,1));
        assertEquals(-2*Math.PI/6, angle);
    }
    @Test
    void Angle_Rudder0_3Left_2RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(3,2));
        assertEquals(-1*Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_Rudder0_0Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(0,1));
        assertEquals(Math.PI/2, angle);
    }

    @Test
    void Angle_Rudder0_1Left_2RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(1,2));
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_Rudder0_2Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(2,3));
        assertEquals(1*Math.PI/6, angle);
    }

    @Test
    void Angle_Rudder0_1Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(0,new NbOarsUsed(1,3));
        assertEquals(2*Math.PI/6, angle);
    }

    /////////
    /////////rudder PI/6
    /////////more left than right

    @Test
    void Angle_RudderPIon6_0Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(0,0));
        assertEquals(Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(1,1));
        assertEquals(Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(1,0));
        assertEquals(-Math.PI/2+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_2Left_1RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(2,1));
        assertEquals(-Math.PI/4+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_3Left_1RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(3,1));
        assertEquals(-2*Math.PI/6+Math.PI/6, angle);
    }
    @Test
    void Angle_RudderPIon6_3Left_2RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(3,2));
        assertEquals(-1*Math.PI/6+Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon6_0Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(0,1));
        assertEquals(Math.PI/2+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_2RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(1,2));
        assertEquals(Math.PI/4+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_2Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(2,3));
        assertEquals(1*Math.PI/6+Math.PI/6, angle);
    }

    @Test
    void Angle_RudderPIon6_1Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/6,new NbOarsUsed(1,3));
        assertEquals(2*Math.PI/6+Math.PI/6, angle);
    }

    /////////
    /////////rudder PI/4
    /////////more left than right

    @Test
    void Angle_RudderPIon4_0Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(0,0));
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(1,1));
        assertEquals(Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(1,0));
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_2Left_1RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(2,1));
        assertEquals(0, angle);
    }

    @Test
    void Angle_RudderPIon4_3Left_1RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(3,1));
        assertEquals(-2*Math.PI/6+Math.PI/4, angle);
    }
    @Test
    void Angle_RudderPIon4_3Left_2RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(3,2));
        assertEquals(-1*Math.PI/6+Math.PI/4, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderPIon4_0Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(0,1));
        assertEquals(Math.PI/2+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_2RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(1,2));
        assertEquals(Math.PI/4+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_2Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(2,3));
        assertEquals(1*Math.PI/6+Math.PI/4, angle);
    }

    @Test
    void Angle_RudderPIon4_1Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(Math.PI/4,new NbOarsUsed(1,3));
        assertEquals(2*Math.PI/6+Math.PI/4, angle);
    }

    /////////
    /////////rudder -PI/6
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon6_0Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(0,0));
        assertEquals(-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(1,1));
        assertEquals(-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(1,0));
        assertEquals(-Math.PI/2-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_1RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(2,1));
        assertEquals(-Math.PI/4-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_3Left_1RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(3,1));
        assertEquals(-2*Math.PI/6-Math.PI/6, angle);
    }
    @Test
    void Angle_RudderMinusPIon6_3Left_2RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(3,2));
        assertEquals(-1*Math.PI/6-Math.PI/6, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon6_0Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(0,1));
        assertEquals(Math.PI/2-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_2RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(1,2));
        assertEquals(Math.PI/4-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_2Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(2,3));
        assertEquals(1*Math.PI/6-Math.PI/6, angle);
    }

    @Test
    void Angle_RudderMinusPIon6_1Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/6,new NbOarsUsed(1,3));
        assertEquals(2*Math.PI/6-Math.PI/6, angle);
    }

    /////////
    /////////rudder -PI/4
    /////////more left than right

    @Test
    void Angle_RudderMinusPIon4_0Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(0,0));
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(1,1));
        assertEquals(-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_0RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(1,0));
        assertEquals(-3*Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_1RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(2,1));
        assertEquals(-Math.PI/2, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_3Left_1RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(3,1));
        assertEquals(-2*Math.PI/6-Math.PI/4, angle);
    }
    @Test
    void Angle_RudderMinusPIon4_3Left_2RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(3,2));
        assertEquals(-1*Math.PI/6-Math.PI/4, angle);
    }

    /////////more right than left

    @Test
    void Angle_RudderMinusPIon4_0Left_1RightOarUse() {
        double angle = ship2OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(0,1));
        assertEquals(Math.PI/2-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_2RightOarUse() {
        double angle = ship4OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(1,2));
        assertEquals(Math.PI/4-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_2Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(2,3));
        assertEquals(1*Math.PI/6-Math.PI/4, angle);
    }

    @Test
    void Angle_RudderMinusPIon4_1Left_3RightOarUse() {
        double angle = ship6OarsMovementResolver.getAngleToTurn(-Math.PI/4,new NbOarsUsed(1,3));
        assertEquals(2*Math.PI/6-Math.PI/4, angle);
    }

    ////////////////// Runner test
    @Test
    void Angle_RunnerTest() {
        double angle = ship10OarsMovementResolver.getAngleToTurn(0.0930508042072854,new NbOarsUsed(5,5));
        assertEquals(0.0930508042072854, angle);
    }

    //////////////////////////////////////////    Test de speed()     //////////////////////////////////////////

    /////////
    /////////Not use Wind
    /////////

    @Test
    void speed_Wind_LowSail_0OarsUseOn6() {
        assertEquals(0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(0,0),0));
    }

    @Test
    void speed_Wind_LowSail_1OarsUseOn6() {
        assertEquals(165/6.0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(0,1),0));
        assertEquals(165/6.0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(1,0),0));
    }

    @Test
    void speed_Wind_LowSail_2OarsUseOn6() {
        assertEquals(165/3.0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(1,1),0));
    }

    @Test
    void speed_Wind_LowSail_4OarsUseOn6() {
        assertEquals(2*165/3.0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(2,2),0));
    }

    @Test
    void speed_Wind_LowSail_6OarsUseOn6() {
        assertEquals(165, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(3,3),0));
    }

    /////////
    /////////Use Wind
    /////////

    /////////Use wind with same angle than ship
    @Test
    void speed_Wind_SameAngle_HighSail_0OarsUseOn6() {
        assertEquals(10, ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(0,0),0));
    }

    @Test
    void speed_Wind_SameAngle_2HighSails_0OarsUseOn6() {
        assertEquals(20, ship6OarsMovementResolver.getSpeed(2, new NbOarsUsed(0,0),0));
    }

    @Test
    void speed_Wind_SameAngle_HighSail_6OarsUseOn6() {
        assertEquals(175, ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),0));
    }

    /////////Use wind with a different angle than ship
    @Test
    void speed_ShipPIon2_LowSail_0OarsUseOn6() {
        assertEquals(0, ship6OarsMovementResolver.getSpeed(0, new NbOarsUsed(0,0),Math.PI/2));
    }

    @Test
    void speed_ShipPIOn4_HighSail_6OarsUseOn6() {
        assertEquals(165+10*Math.cos(Math.PI/4), ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),Math.PI/4));
    }

    @Test
    void speed_Ship3PIOn4_HighSail_6OarsUseOn6() {
        assertEquals(165-10*Math.cos(Math.PI/4), ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),3*Math.PI/4));
    }

    @Test
    void speed_ShipMinusPIOn4_HighSail_6OarsUseOn6() {
        assertEquals(165+10*Math.cos(Math.PI/4), ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),-Math.PI/4));
    }

    @Test
    void speed_ShipPIOn2_HighSail_6OarsUseOn6() {
        assertEquals(165, ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),Math.PI/2));
    }

    @Test
    void speed_ShipMinusPIOn2_HighSail_6OarsUseOn6() {
        assertEquals(165, ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),-Math.PI/2));
    }

    @Test
    void speed_ShipPI_HighSail_6OarsUseOn6() {
        assertEquals(165-10, ship6OarsMovementResolver.getSpeed(1, new NbOarsUsed(3,3),Math.PI));
    }

    @Test
    void speed_ShipMinusPIOn2_HighSail_6OarsUseOn6_WindPIOn2() {
        ShipMovementResolver ship6OarsWindPIOn2MovementResolver = new ShipMovementResolver(mockShip6Oars1Sail,new Wind(10,Math.PI/2), null);
        assertEquals(165-10, ship6OarsWindPIOn2MovementResolver.getSpeed(1, new NbOarsUsed(3,3),-Math.PI/2));
    }

    ////////////////// Runner test

    @Test
    void speed_RunnerTest() {
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0), null);
        assertEquals(165+50*Math.cos(1.0297442586766543), shipMovementResolver.getSpeed(1, new NbOarsUsed(5,5),1.0297442586766543));
    }

    //////////////////////////////////////    Test de resolveNewPosition()     //////////////////////////////////////

    @Test
    void nextTurnPosition_0OarToUse_0Sail_0Rudder() {
        Mockito.when(mockShip10Oars1Sail.isSailsOpen()).thenReturn(false);
        Mockito.when(mockShip10Oars1Sail.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0), null);

        assertEquals(new Position(0,0,0),shipMovementResolver.resolveNextTurnPosition(0, SailAction.DO_NOTHING,new NbOarsUsed(0,0)));
    }

    @Test
    void nextPosition_0OarToUse_1Sail_0Rudder() {
        Mockito.when(mockShip10Oars1Sail.isSailsOpen()).thenReturn(true);
        Mockito.when(mockShip10Oars1Sail.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0),null);

        assertEquals(new Position(50,0,0),shipMovementResolver.resolveNextTurnPosition(0,SailAction.DO_NOTHING,new NbOarsUsed(0,0)));
    }

    @Test
    void nextPosition_AllOarToUse_0Sail_0Rudder() {
        Mockito.when(mockShip10Oars1Sail.isSailsOpen()).thenReturn(false);
        Mockito.when(mockShip10Oars1Sail.getPosition()).thenReturn(new Position(0,0,0));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0), null);

        assertEquals(new Position(165.0000000000003,0,0),shipMovementResolver.resolveNextTurnPosition(0,SailAction.DO_NOTHING,new NbOarsUsed(5,5)));
    }

    ////////////////// Runner test

    @Test
    void rudderTestRound0() {
        Mockito.when(mockShip10Oars1Sail.isSailsOpen()).thenReturn(false);
        Mockito.when(mockShip10Oars1Sail.getPosition()).thenReturn(new Position(2852.173913043478,1978.827361563518,-1.0297442586766543));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0),null);

        assertEquals(new Position(2958.9016642451215, 1818.4806682445735, -0.9366934544693667),shipMovementResolver.resolveNextTurnPosition(0.0930508042072854,SailAction.LIFT,new NbOarsUsed(5,5)));
    }

    @Test
    void rudderTestRound1() {
        Mockito.when(mockShip10Oars1Sail.isSailsOpen()).thenReturn(false);
        Mockito.when(mockShip10Oars1Sail.getPosition()).thenReturn(new Position(2958.9016642451215, 1818.4806682445735, -0.9366934544693667));
        ShipMovementResolver shipMovementResolver = new ShipMovementResolver(mockShip10Oars1Sail,new Wind(50,0),null);

        assertEquals(new Position(3074.2068908993306, 1661.6918931870753, -0.9366934544693667),shipMovementResolver.resolveNextTurnPosition(0.0,SailAction.LIFT,new NbOarsUsed(5,5)));
    }

    @Nested
    class checkpointCalculateTest {

        ShipMovementResolver shipMovementResolver;
        Checkpoint checkpoint100RadiusIn0_0;
        Checkpoint checkpoint60RadiusIn50_Minus50;
        RegattaGoal mockRegattaGoal;
        Position position;
        Ship mockShip;

        @BeforeEach
        void setUp(){
            checkpoint100RadiusIn0_0 = new Checkpoint(new Position(0, 0, 0), new Circle(100));
            checkpoint60RadiusIn50_Minus50 = new Checkpoint(new Position(0, -50, 0), new Circle(60));
            mockShip = Mockito.mock(Ship.class);
            Mockito.when(mockShip.getNbOars()).thenReturn(6);
            Mockito.when(mockShip.getNbSails()).thenReturn(1);
            mockRegattaGoal = Mockito.mock(RegattaGoal.class);
            shipMovementResolver = new ShipMovementResolver(mockShip, new Wind(50,0), mockRegattaGoal);

        }

        //////////////////////////////////////////////////   isPositionInCheckpoint()   //////////////////////////////////////////////////

        ///// checkpoint 100 radius In 0_0

        @Test
        void PositionEqualsCheckpoint_rad0(){
            position = new Position(0,0,0);
            Checkpoint checkpoint0Radius = new Checkpoint(new Position(0, 0, 0), new Circle(0));
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint0Radius);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionEqualsCheckpoint_rad100(){
            position = new Position(0,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf50XOfCheckpoint_rad100(){
            position = new Position(50,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf50YOfCheckpoint_rad100(){
            position = new Position(0,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf50Y50XOfCheckpoint_rad100(){
            position = new Position(50,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOfMinus50Y50XOfCheckpoint_rad100(){
            position = new Position(-50,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOfMinus50YMinus50XOfCheckpoint_rad100(){
            position = new Position(-50,-50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf50YMinus50XOfCheckpoint_rad100(){
            position = new Position(50,-50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf100XOfCheckpoint_rad100(){
            position = new Position(100,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf100YOfCheckpoint_rad100(){
            position = new Position(0,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf100Y100XOfCheckpoint_rad100(){
            position = new Position(100,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOfMinus100Y100XOfCheckpoint_rad100(){
            position = new Position(-100,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOfMinus100YMinus100XOfCheckpoint_rad100(){
            position = new Position(-100,-100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf100YMinus100XOfCheckpoint_rad100(){
            position = new Position(100,-100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionFarOf110XOfCheckpoint_rad100(){
            position = new Position(110,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        ///// checkpoint 60 radius In 50_0

        @Test
        void PositionIn0_0_rad60(){
            position = new Position(0,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionIn50_0_rad60(){
            position = new Position(50,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionIn0_50_rad60(){
            position = new Position(0,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionIn50_50_rad60(){
            position = new Position(50,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionInMinus50_50_rad60(){
            position = new Position(-50,50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionInMinus50_Minus50_rad60(){
            position = new Position(-50,-50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionIn50_Minus50_rad60(){
            position = new Position(50,-50,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertTrue(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void Position100_0_rad60(){
            position = new Position(100,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void Position0_100_rad60(){
            position = new Position(0,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void Position100_100_rad60(){
            position = new Position(100,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionMinus100_100_rad60(){
            position = new Position(-100,100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void PositionMinus100_Minus100_rad60(){
            position = new Position(-100,-100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void Position100_Minus100_rad60(){
            position = new Position(100,-100,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        @Test
        void Position110_0_rad60(){
            position = new Position(110,0,0);
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint60RadiusIn50_Minus50);
            assertFalse(shipMovementResolver.isPositionInCheckpoint(position));
        }

        //////////////////////////////////////////////////   isCheckpointMissed()   //////////////////////////////////////////////////

        @Test
        void endPositionEqualsCheckpointPosition(){
            Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
            Mockito.when(mockShip.getPosition()).thenReturn(new Position(-165,0,0));
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isCheckpointMissed(new Position(100,0,0),0,SailAction.DO_NOTHING,new NbOarsUsed(3,3)));
        }

        @Test
        void endPositionInCheckpointPosition(){
            Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
            Mockito.when(mockShip.getPosition()).thenReturn(new Position(-66,0,0));
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertFalse(shipMovementResolver.isCheckpointMissed(new Position(100,0,0),0,SailAction.DO_NOTHING,new NbOarsUsed(3,3)));
        }

        @Test
        void endPositionAfterCheckpointPosition(){
            Mockito.when(mockShip.isSailsOpen()).thenReturn(false);
            Mockito.when(mockShip.getPosition()).thenReturn(new Position(-65,0,0));
            Mockito.when(mockRegattaGoal.getActualCheckpoint()).thenReturn(checkpoint100RadiusIn0_0);
            assertTrue(shipMovementResolver.isCheckpointMissed(new Position(100,0,0),0,SailAction.DO_NOTHING,new NbOarsUsed(3,3)));
        }
    }
}