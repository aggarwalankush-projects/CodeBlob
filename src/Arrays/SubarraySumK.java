package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an unsorted array of non-negative integers,
 * find a contiguous subarray which adds to a given number.
 */
public class SubarraySumK {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Subarray sum equals K:");
        System.out.println("Input: " + Arrays.toString(array) + ", K = 16");
        System.out.println(findSubarray(array, 16));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    private static String findSubarray(int[] array, int k) {
        int cur_sum = array[0];
        int start = 0;
        for (int end = 1; end < array.length; end++) {
            while (cur_sum > k && start < end) {
                cur_sum -= array[start];
                start++;
            }
            if (cur_sum == k)
                return subarray(array, start, end);
            cur_sum += array[end];
        }
        return "No subarray found";
    }

    private static String subarray(int[] array, int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++)
            list.add(array[i]);
        return "Index: (" + start + ", " + (end - 1) + ") and subarray -> " + list.toString();
    }
}
