/**
 * Created by Kevin on 2/26/2017.
 * Direction is a enumeration that represents the 8 directions a word can be in. Note that the grid starts at
 * (0,0) and goes down. So to move south, we are increasing y, so we are really navigating an inverted cartesian plane
 */
public enum Direction {
    NORTH(0,-1),
    SOUTH(0,1),
    EAST(1,0),
    WEST(-1,0),
    NORTHEAST(1,-1),
    NORTHWEST(-1,-1),
    SOUTHEAST(1,1),
    SOUTHWEST(-1,1);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}
