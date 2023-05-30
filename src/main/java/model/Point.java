package model;

import lombok.Data;

/**
 * A point coordinate object, which has an x and y integer
 */
@Data
public class Point {
    private int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
