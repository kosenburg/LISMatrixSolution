import java.io.IOException;

/**
 * Created by Kevin on 3/12/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Solver solver = new Solver();
        solver.loadMatrix("testFiles/testDataHW3.txt");
        //solver.loadMatrix("testFiles/testDataProb1.txt");
        solver.solve();
        solver.outputAnswer();
    }

}
