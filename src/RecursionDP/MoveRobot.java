package RecursionDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Imagine a robot sitting on the upper left corner of an X by Y grid.
 * Find the path of robot to go from (0, 0) to (X, Y)
 * Assumption:
 * 1. Robot can either move Right or Down
 * 2. Robot can't step on certain spots
 */
public class MoveRobot {
    static int[][] maze = {
            {0, 0, 1, 1},
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 0, 0}
    };

    public static void main(String[] args) {
        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> buffer = new HashMap<>();
        System.out.println("Input Maze:");
        printMatrix(maze);
        boolean pathExists = getPathDP(3, 3, path, buffer);
        if (pathExists)
            System.out.println("Robot Path: " + path);
        else
            System.out.println("No possible path found");
    }


    public static boolean getPathRecursion(int x, int y, ArrayList<Point> path) {
        if (x < 0 || y < 0 || !isFree(x, y))
            return false;
        boolean reachedOrigin = (x == 0 && y == 0);
        if (reachedOrigin || getPathRecursion(x - 1, y, path) || getPathRecursion(x, y - 1, path)) {
            Point p = new Point(x, y);
            path.add(p);
            return true;
        }
        return false;
    }

    public static boolean getPathDP(int x, int y, ArrayList<Point> path, HashMap<Point, Boolean> buffer) {
        if (x < 0 || y < 0 || !isFree(x, y))
            return false;
        Point p = new Point(x, y);
        if (buffer.containsKey(p))
            return buffer.get(p);
        boolean reachedOrigin = (x == 0 && y == 0);
        boolean success = false;
        if (reachedOrigin || getPathRecursion(x - 1, y, path) || getPathRecursion(x, y - 1, path)) {
            path.add(p);
            success = true;
        }
        buffer.put(p, success);
        return success;
    }


    public static boolean isFree(int x, int y) {
        return maze[x][y] == 0;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
