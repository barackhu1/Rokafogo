package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RokafogoModelTest {
    RokafogoModel model1 = new RokafogoModel();
    RokafogoModel model2 = new RokafogoModel();
    List<Point> pointList1;
    List<Point> pointList2;
    @BeforeEach
    void setUp() {
        pointList1 = Arrays.asList(new Point(model1.getWhitePawn().getX(),model1.getWhitePawn().getY()),
                new Point(model1.getBlackPawn1().getX(),model1.getBlackPawn1().getY()),
                new Point(model1.getBlackPawn2().getX(),model1.getBlackPawn2().getY()),
                new Point(model1.getBlackPawn3().getX(), model1.getBlackPawn3().getY()),
                new Point(model1.getBlackPawn4().getX(),model1.getBlackPawn4().getY()));
        model1.removesPiece(model1.getWhitePawn().ableToMove());
        model2.setWhitePawn(new WhitePawn(7, 7));
        model2.setBlackPawn1(new BlackPawn(6,6));
        model2.setBlackPawn2(new BlackPawn(4,2));
        model2.setBlackPawn3(new BlackPawn(5,4));
        model2.setBlackPawn4(new BlackPawn(3,1));
        pointList2 = Arrays.asList(new Point(model2.getWhitePawn().getX(),model2.getWhitePawn().getY()),
                new Point(model2.getBlackPawn1().getX(),model2.getBlackPawn1().getY()),
                new Point(model2.getBlackPawn2().getX(),model2.getBlackPawn2().getY()),
                new Point(model2.getBlackPawn3().getX(), model2.getBlackPawn3().getY()),
                new Point(model2.getBlackPawn4().getX(),model2.getBlackPawn4().getY()));
        model2.removesPiece(model2.getWhitePawn().ableToMove());
    }

    @Test
    void piecesList(){
        assertEquals(pointList1, model1.piecesList());
        assertEquals(pointList2, model2.piecesList());
    }

    @Test
    void whiteWins(){
        assertFalse(model1.whiteWins());
        assertTrue(model2.whiteWins());
    }

    @Test
    void blackWins(){
        assertFalse(model1.blackWins());
        assertTrue(model2.blackWins());
    }
}
