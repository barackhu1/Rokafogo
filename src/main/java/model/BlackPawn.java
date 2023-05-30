package model;

import java.util.ArrayList;
import java.util.List;

/**
 * The class defines a black piece
 */
public class BlackPawn extends Piece {
    public BlackPawn(int x, int y) {
        super(x, y);
    }

    /**
     * From the black piece current position gets ist valid coordinates
     * @return a list of valid moves
     */
    public List<Point> ableToMove(){
        List<Point> pieceList = new ArrayList<>();
        if (getX()+1 < getTABLE() && getY()-1 >= 0){
            pieceList.add(new Point(getX()+1,getY()-1));
        }
        if (getX()-1 >= 0 && getY()-1 >= 0){
            pieceList.add(new Point(getX()-1,getY()-1));
        }
        return pieceList;
    }
}
