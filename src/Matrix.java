import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Kevin on 3/12/2017.
 */
public class Matrix {
    private int[][] matrix;

    public Matrix() {
        matrix = new int[15][15];
        //matrix = new int[4][4];
    }

    public void loadMatrix(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String line;
        int row = 0;
        while((line = reader.readLine()) != null) {
            String[] elements = line.split(",");
            fillrow(row, elements);
            row++;
        }
    }

    public int getNumberOfRows() {
        return matrix.length;
    }

    public int getNumberOfColumns() {
        return matrix[0].length;
    }

    private void fillrow(int row, String[] elements) {
        int column = 0;
        for (String element: elements){
            matrix[row][column] = Integer.parseInt(element.trim());
            column++;
        }
    }

    public int getValueAt(Point p) {
        return matrix[p.getX()][p.getY()];
    }

    public boolean isInBounds(Point p) {
        if ((p.getY() >= 0) && (p.getY() < matrix.length)) {
            if ((p.getX() >= 0) && (p.getX() < matrix[p.getY()].length)) {
                return true;
            }
        }
        return false;
    }
}
