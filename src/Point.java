/**
 * Created by Kevin on 3/12/2017.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point moveIn(Direction direction) {
        return new Point(x + direction.getDx(), y + direction.getDy());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
