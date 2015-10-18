package RecursionDP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Find all ways of arranging N queens on an NxN chess board
 * so that none of them share the same row, column or diagonal.
 */
public class NQueens {

    static int grid_size;

    public static void main(String[] args) {
        grid_size = 4;
        System.out.println("Ways to arrange " + grid_size + " queens: ");
        printList(findWays(grid_size));
    }

    public static ArrayList<Integer[]> findWays(int n) {
        ArrayList<Integer[]> list = new ArrayList<>();
        findWays(0, new Integer[grid_size], list);
        return list;
    }

    private static void findWays(int row, Integer[] queenPos, ArrayList<Integer[]> list) {
        if (row == grid_size)
            list.add(queenPos.clone());
        else {
            for (int col = 0; col < grid_size; col++) {
                if (isValid(row, col, queenPos)) {
                    queenPos[row] = col;
                    findWays(row + 1, queenPos, list);
                }
            }
        }
    }

    private static boolean isValid(int row, int col, Integer[] queenPos) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            int prevCol = queenPos[prevRow];
            //same column
            if (prevCol == col)
                return false;
            //same diagonal
            int rowDistance = row - prevRow;
            int colDistance = Math.abs(prevCol - col);
            if (rowDistance == colDistance)
                return false;
        }
        return true;
    }

    private static void printList(ArrayList<Integer[]> list) {
        for (Integer[] queenPos : list)
            System.out.println(Arrays.toString(queenPos));
    }
}
