package fr.unice.polytech.si3.qgl.queleglitch.json.goal;

import fr.unice.polytech.si3.qgl.queleglitch.json.game.Position;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Circle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Rectangle;
import fr.unice.polytech.si3.qgl.queleglitch.json.shape.Shape;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Level;

import static org.junit.jupiter.api.Assertions.*;

class CheckpointTest {



    Position positionCheckpoint;
    Position newPositionCheckpoint;
    Checkpoint circleCheckpoint_1;
    Checkpoint checkpointSquare_1;
    Circle circle_1;
    Rectangle rectangle_1_1;

    static double RADIUS_1 =1.0;
    static double BAD_RADIUS =-1.0;
    static double RADIUS_2 =2.0;

    @BeforeEach
    void setUp() {
        rectangle_1_1 = new Rectangle(1,1,0);
        positionCheckpoint = new Position(0, 0, 0);
        newPositionCheckpoint = new Position(1, 0, 0);
        checkpointSquare_1 = new Checkpoint(positionCheckpoint,rectangle_1_1);
        circle_1 =new Circle(RADIUS_1);
        circleCheckpoint_1 = new Checkpoint(positionCheckpoint,circle_1);
    }

    @Test
    void goodRadiusFromCircleCheckpoint (){
        assertEquals(RADIUS_1,circleCheckpoint_1.getRadius());
    }

    @Test
    void badRadiusBecauseRectangle(){
        assertEquals(BAD_RADIUS,checkpointSquare_1.getRadius());
    }

    @Test
    void differentRadiusExpected(){
        assertNotEquals(RADIUS_2,circleCheckpoint_1.getRadius());
    }


    @Test
    void newPositionCheckpointSet(){
        circleCheckpoint_1.setPosition(newPositionCheckpoint);
        assertEquals(newPositionCheckpoint,circleCheckpoint_1.getPosition());
    }

    @Test
    void differentShape(){
        assertNotEquals(checkpointSquare_1.getShape(),circleCheckpoint_1.getShape());
    }

    @Test
    void newShapeSet(){
        checkpointSquare_1.setShape(circle_1);
        assertEquals(circleCheckpoint_1.getShape(),checkpointSquare_1.getShape());
    }

    @Test
    void toStringTest(){
        assertEquals(" | Checkpoint | x : 0.0 | y : 0.0",checkpointSquare_1.toString());

    }

    @Test
    void EqualityTest(){
        Shape shapeCheckpoint2 = new Rectangle(1,1,0);
        Position positionCheckpoint2 = new Position(0, 0, 0);
        Checkpoint checkpointSquare_2 = new Checkpoint(positionCheckpoint2,shapeCheckpoint2);
        assertEquals(checkpointSquare_1,checkpointSquare_2);
        assertNotEquals(checkpointSquare_1,circleCheckpoint_1);
    }

}