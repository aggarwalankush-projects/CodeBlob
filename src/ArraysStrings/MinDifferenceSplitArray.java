package ArraysStrings;

import java.util.Arrays;

/**
 * Splitting an array into two subarrays with minimal sum
 */
public class MinDifferenceSplitArray {

    public static void main(String[] args) {
        int[] array = {7, 3, 2, 6, 1, 6, 4};
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("Minimum Difference in two subarrays: " + divide(array, 0, 0, 0));
    }


    public static int divide(int[] a, int i, int X, int Y) {
        if (i >= a.length) {
            return Math.abs(X - Y);
        } else {
            int x1 = divide(a, i + 1, X + a[i], Y);
            int x2 = divide(a, i + 1, X, Y + a[i]);
            return Math.min(x1, x2);
        }
    }
}
