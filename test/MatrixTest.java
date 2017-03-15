import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Kevin on 3/12/2017.
 */
public class MatrixTest {
    @Test
    public void loadMatrix() throws Exception {
    Matrix matrix = new Matrix();
    matrix.loadMatrix("testFiles/testDataHW3.txt");
    }

    @Test
    public void getNumberOfRows() throws Exception {
        Matrix matrix = new Matrix();
        matrix.loadMatrix("testFiles/testDataHW3.txt");
        System.out.println(matrix.getNumberOfColumns());
        Assert.assertEquals(15,matrix.getNumberOfRows());
    }

    @Test
    public void getNumberOfColumns() throws Exception {
        Matrix matrix = new Matrix();
        matrix.loadMatrix("testFiles/testDataHW3.txt");
        System.out.println(matrix.getNumberOfRows());
        Assert.assertEquals(15, matrix.getNumberOfColumns());
    }

    @Test
    public void getValueAt() throws Exception {
        Matrix matrix = new Matrix();
        matrix.loadMatrix("testFiles/testDataHW3.txt");
        Assert.assertEquals(48,matrix.getValueAt(new Point(0,0)));
    }

    @Test
    public void isInBounds() throws Exception {
        Matrix matrix = new Matrix();
        matrix.loadMatrix("testFiles/testDataHW3.txt");
        Assert.assertTrue(matrix.isInBounds(new Point(14,14)));
        Assert.assertFalse(matrix.isInBounds(new Point(15,15)));
    }

}