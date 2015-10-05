package ArraysStrings;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array a[] and number K,
 * determines whether or not there exist two elements in array a[]
 * whose sum is exactly K.
 */
public class SumPair {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Pair of sum equals K:");
        System.out.println("Input: " + Arrays.toString(array) + ", K = 15");
        findPair(array, 15);
    }

    /**
     * Time Complexity: O(N)
     */
    private static void findPair(int[] array, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int index = map.get(array[i]);
                System.out.println("Index: (" + index + ", " + i + ") and Pair: (" + array[index] + ", " + array[i] + ")");
                break;
            } else {
                map.put(k - array[i], i);
            }
        }
    }
}
