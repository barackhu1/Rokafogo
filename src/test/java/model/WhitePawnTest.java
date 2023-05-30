package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhitePawnTest {

    WhitePawn whitePawn1;
    WhitePawn whitePawn2;
    WhitePawn whitePawn3;
    WhitePawn whitePawn4;
    List<Point> pointList1;
    List<Point> pointList2;
    List<Point> pointList3;
    List<Point> pointList4;

    @BeforeEach
    void setUp() {
        whitePawn1 = new WhitePawn(0,0);
        whitePawn2 = new WhitePawn(5,5);
        whitePawn3 = new WhitePawn(7,7);
        whitePawn4 = new WhitePawn(3,6);
        pointList1 = Stream.of(new Point(1, 1)).toList();
        pointList2 = Stream.of(new Point(6, 6), new Point(4, 6), new Point(6, 4), new Point(4, 4)).toList();
        pointList3 = Stream.of(new Point(6, 6)).toList();
        pointList4 = Stream.of(new Point(4, 7), new Point(2, 7), new Point(4, 5), new Point(2, 5)).toList();
    }

    @Test
    void ableToMove(){
        assertEquals(pointList1,whitePawn1.ableToMove());
        assertEquals(pointList2,whitePawn2.ableToMove());
        assertEquals(pointList3,whitePawn3.ableToMove());
        assertEquals(pointList4,whitePawn4.ableToMove());
    }
}
