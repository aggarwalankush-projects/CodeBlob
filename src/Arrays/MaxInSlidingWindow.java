package Arrays;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * There is a sliding window of size k which is moving from the very left of the array to the very right.
 * Each time the sliding window moves right by one position.
 */
public class MaxInSlidingWindow {

    public static void main(String[] args) {
        int[] array = {7, 3, 2, 4, 1, 6, 4};
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("For window size 3, max for each window:");
        findKMax(array, 3);
    }


    public static void findKMax(int[] array, int k) {
        if (array == null)
            return;

        int len = array.length;
        // for first window - find max.
        int[] result = findMax(array, 0, k);
        int max = result[0];
        int max_index = result[1];
        printArray(array, 0, k, max);

        for (int i = 1; i <= (len - k); i++) {
            // if previous max has fallen out of current window
            if (max_index < i) {
                result = findMax(array, i, i + k);
                max = result[0];
                max_index = result[1];
            } else {
                // optimized path, just compare max with new_elem that has come into the window
                int new_elem_index = i + k - 1;
                if (array[new_elem_index] > max) {
                    max = array[new_elem_index];
                    max_index = new_elem_index;
                }
            }
            printArray(array, i, i + k, max);
        }
    }

    // finds the max and its index
    private static int[] findMax(int[] array, int begin, int end) {
        int max = Integer.MIN_VALUE;
        int max_index = -1;
        for (int i = begin; i < end; i++) {
            if (array[i] > max) {
                max = array[i];
                max_index = i;
            }
        }
        return new int[]{max, max_index};
    }

    private static void printArray(int[] array, int begin, int end, int max) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            list.add(array[i]);
        }
        System.out.println(list + " -> " + max);
    }
}
