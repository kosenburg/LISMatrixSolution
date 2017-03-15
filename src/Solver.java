import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Kevin on 3/12/2017.
 */
public class Solver {
    private Matrix matrix;
    private Stack<Point> maxSequence;

    public Solver() {
        matrix = new Matrix();
        maxSequence = new Stack<>();
    }

    public void loadMatrix(String filePath) throws IOException {
        matrix.loadMatrix(filePath);
    }

    public void solve() {
        for (int j = 0; j < matrix.getNumberOfRows(); j++) {
            for (int k = 0; k < matrix.getNumberOfColumns(); k++) {
                Point startingPoint = new Point(j,k);
                /*
                System.out.println("Starting at: " + matrix.getValueAt(startingPoint));
                System.out.println("diving...");
                */
                Stack<Point> currentStack = new Stack<>();
                currentStack.push(startingPoint);
                dive(currentStack, startingPoint);
            }
        }
    }


    private Stack<Point> dive(Stack<Point> stack, Point startingPoint) {
        ArrayList<Point> localPoints  = getLocalPoints(startingPoint);
        //System.out.println("Working on point: (" + startingPoint.getX() + ", " + startingPoint.getY() + ")");

        for (Point pt: localPoints) {
            if (matrix.isInBounds(pt) && (matrix.getValueAt(pt) > matrix.getValueAt(startingPoint))) {
                //System.out.println("Passes test at: " + matrix.getValueAt(pt) + "(" + pt.getX() + ", " + pt.getY() + ")");
                stack.push(pt);
                stack = dive(stack, pt);
                stack.pop();
                //System.out.println("Back at point: (" + startingPoint.getX() + ", " + startingPoint.getY() + ")");
                //System.out.println("Current stack is:");
                //printStack(stack);
            } else {
                //System.out.println("Test failed at:" + "(" + pt.getX() + ", " + pt.getY() + ")");
                checkStack(stack);
            }
        }
        return stack;
    }

    private void checkStack(Stack<Point> stack) {
        if (stack.size() > maxSequence.size()) {
            //System.out.println("Old max stack length " + maxSequence.size() + ":");
            //printStack(maxSequence);
            //System.out.println("New max stack length " + stack.size() + ":");
            //printStack(stack);
            maxSequence = (Stack<Point>) stack.clone();
        }
    }

    private void printStack(Stack<Point> stack) {
        Stack<Point> printStack = (Stack<Point>) stack.clone();
        StringBuilder builder = new StringBuilder();

        while (printStack.size() != 0) {
            Point point = printStack.pop();
            builder.append("(" + point.getX() + ", " + point.getY() + ")");
        }
        System.out.println(builder.toString());
    }


    public ArrayList<Point> getLocalPoints(Point startingPoint) {
        ArrayList<Point> points = new ArrayList<>();

        for (Direction direction: Direction.values()) {
            Point point = startingPoint.moveIn(direction);
            points.add(point);
        }
        return points;
    }

    public void outputAnswer() {

        // fence post
        while (maxSequence.size() > 0) {
            Point point = maxSequence.pop();
            System.out.println(matrix.getValueAt(point) + "\t" + "( " + point.getX() + ", " + point.getY() + ")");
        }

    }

}
