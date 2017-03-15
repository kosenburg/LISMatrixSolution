import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 3/12/2017.
 */
public class SolverTest {
    @Test
    public void loadMatrix() throws Exception {
        Solver solver = new Solver();
        solver.loadMatrix("testFiles/testDataHW3.txt");
    }

    @Test
    public void getLocalPoints() throws Exception {
        Solver solver = new Solver();
        solver.loadMatrix("testFiles/testDataHW3.txt");
        ArrayList<Point> locals = solver.getLocalPoints(new Point(0,0));
        for (Point p: locals) {
            System.out.println("x = " + p.getX() + " y = " + p.getY());
        }

    }

}