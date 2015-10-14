package Arrays;

import java.util.Arrays;

/**
 * Given an array arr[] of integers,
 * find out the maximum difference between two elements such that
 * larger element appears after the smaller number in arr[].
 */
public class MaxElementDifference {

    public static void main(String[] args) {
        int[] array1 = {10, 9, 5, 6, 8, 11, 10};
        System.out.println("Input Array: " + Arrays.toString(array1));
        System.out.println("Max Difference: " + findMaxDiff(array1));
        int[] array2 = {10, 9, 8, 7, 6};
        System.out.println("\nInput Array: " + Arrays.toString(array2));
        System.out.println("Max difference: " + findMaxDiff(array2));

    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findMaxDiff(int[] array) {
        int len = array.length;
        if (len < 2) return -1;
        int max_diff = array[1] - array[0];
        int min_elem = array[0];
        for (int i = 1; i < len; i++) {
            max_diff = Math.max(max_diff, array[i] - min_elem);
            min_elem = Math.min(min_elem, array[i]);
        }
        return max_diff;
    }


}
