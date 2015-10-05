package ArraysStrings;

import java.util.ArrayList;
import java.util.Arrays;

public class MinDifferenceSplitArray {

    public static void main(String[] args) {
        int[] array = {7, 3, 2, 6, 1, 6, 4};
        System.out.println("Input Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Minimum Difference between 2 splits:");
        System.out.println(divide(array, 0, 0, 0));
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
