package model;

/**
 * Defines a basic Piece object
 */
@lombok.Data
public class Piece{
    private int x, y;
    private int TABLE = 8;
    public Piece(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
