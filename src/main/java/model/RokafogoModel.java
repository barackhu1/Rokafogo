package model;

import java.util.Arrays;
import java.util.List;

/**
 * Defines the whole board game, with the pieces coordinates, their move list and some core methods
 */
@lombok.Data
public class RokafogoModel {
    private int nextPlayer = 1;
    private boolean clickedOn = true;
    private WhitePawn whitePawn = new WhitePawn(2,0);
    private BlackPawn blackPawn1 = new BlackPawn(1,7);
    private BlackPawn blackPawn2 = new BlackPawn(3,7);
    private BlackPawn blackPawn3 = new BlackPawn(5,7);
    private BlackPawn blackPawn4 = new BlackPawn(7,7);
    private List<Point> whiteMoveList;
    private List<Point> blackMoveList1;
    private List<Point> blackMoveList2;
    private List<Point> blackMoveList3;
    private List<Point> blackMoveList4;

    /**
     * Creates the list of valid moves for the 5 pieces
     */
    public void createLists(){
        whiteMoveList = whitePawn.ableToMove();
        blackMoveList1 = blackPawn1.ableToMove();
        blackMoveList2 = blackPawn2.ableToMove();
        blackMoveList3 = blackPawn3.ableToMove();
        blackMoveList4 = blackPawn4.ableToMove();
    }

    /**
     * @return a list of the 5 piece coordinates
     */
    public List<Point> piecesList(){
        return Arrays.asList(new Point(whitePawn.getX(),whitePawn.getY()),new Point(blackPawn1.getX(),blackPawn1.getY()),
                new Point(blackPawn2.getX(),blackPawn2.getY()),new Point(blackPawn3.getX(), blackPawn3.getY()),
                new Point(blackPawn4.getX(),blackPawn4.getY()));
    }

    /**
     * Using the pieceList() method we remove other pieces from valid list moves
     * @param list a coordinate list of pieces
     */
    public void removesPiece(List<Point> list){
        for (var point : piecesList()){
            list.remove(point);
        }
    }

    /**
     * If the white piece is behind of the dogs, the method returns true
     * @return returns a logical variable based on the white winning situation
     */
    public boolean whiteWins(){
        return (whitePawn.getY() > blackPawn1.getY()) && (whitePawn.getY() > blackPawn2.getY()) &&
                (whitePawn.getY() > blackPawn3.getY()) && (whitePawn.getY() > blackPawn4.getY());
    }

    /**
     * If the black pieces cornered the white piece, the method returns true
     * @return returns a logical variable based on the black winning situation
     */
    public boolean blackWins(){
        List<Point> whiteMoves = whitePawn.ableToMove();
        removesPiece(whiteMoves);
        return whiteMoves.isEmpty();
    }

}
