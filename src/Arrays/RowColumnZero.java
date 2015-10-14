package Arrays;

import java.util.Arrays;

/**
 * Given a m * n matrix, if an element is 0, set its entire row and column to 0.
 */
public class RowColumnZero {

    public static void main(String[] args) {
        int[][] array = {
                {1, 1, 1, 1},
                {1, 1, 1, 0},
                {1, 0, 1, 1},
                {1, 1, 1, 1}};
        System.out.println("Input Array:");
        printArray(array);
        processArray(array);
        System.out.println("Processed Array:");
        printArray(array);
    }

    /**
     * Time complexity: O(nm)
     */
    public static void processArray(int[][] array) {
        if (array == null)
            return;
        boolean[] row = new boolean[array.length];
        boolean[] col = new boolean[array[0].length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (row[i] || col[j]) {
                    array[i][j] = 0;
                }
            }
        }
    }

    private static void printArray(int[][] array) {
        for (int[] row : array) {
            System.out.println(Arrays.toString(row));
        }
    }

}
