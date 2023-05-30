package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BlackPawnTest {

    BlackPawn blackPawn1;
    BlackPawn blackPawn2;
    BlackPawn blackPawn3;
    BlackPawn blackPawn4;
    List<Point> pointList1;
    List<Point> pointList2;
    List<Point> pointList3;
    List<Point> pointList4;

    @BeforeEach
    void setUp() {
        blackPawn1 = new BlackPawn(0,0);
        blackPawn2 = new BlackPawn(5,5);
        blackPawn3 = new BlackPawn(7,7);
        blackPawn4 = new BlackPawn(3,6);
        pointList1 = new ArrayList<>();
        pointList2 = Stream.of(new Point(6,4) ,new Point(4,4)).toList();
        pointList3 = Stream.of(new Point(6,6)).toList();
        pointList4 = Stream.of(new Point(4, 5), new Point(2, 5)).toList();
    }

    @Test
    void ableToMove(){
        assertEquals(pointList1,blackPawn1.ableToMove());
        assertEquals(pointList2,blackPawn2.ableToMove());
        assertEquals(pointList3,blackPawn3.ableToMove());
        assertEquals(pointList4,blackPawn4.ableToMove());
    }
}
