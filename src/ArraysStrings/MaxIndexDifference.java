package ArraysStrings;

import java.util.Arrays;

/**
 * Given an array arr[], find the maximum index difference j – i such that arr[j] > arr[i].
 */
public class MaxIndexDifference {

    public static void main(String[] args) {
        int[] array1 = {10, 9, 5, 6, 8, 11, 10};
        System.out.println("Input Array: " + Arrays.toString(array1));
        findMaxDiffIndex(array1);
        int[] array2 = {10, 9, 8, 7, 6};
        System.out.println("\nInput Array: " + Arrays.toString(array2));
        findMaxDiffIndex(array2);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static void findMaxDiffIndex(int[] array) {
        int len = array.length;
        if (len < 2) return;
        int[] leftMin = new int[len];
        int[] rightMax = new int[len];
        leftMin[0] = array[0];
        for (int i = 1; i < len; i++)
            leftMin[i] = Math.min(leftMin[i - 1], array[i]);
        rightMax[len - 1] = array[len - 1];
        for (int i = len - 2; i >= 0; i--)
            rightMax[i] = Math.max(rightMax[i + 1], array[i]);

        int i = 0, j = 0, maxDiff = -1, max_begin = -1, max_end = -1;
        while (i < len && j < len) {
            if (leftMin[i] < rightMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                max_begin = i;
                max_end = j;
                j++;
            } else
                i++;
        }
        System.out.println("Max Difference indexes -> j: " + max_end + ", i: " + max_begin + ", and diff: " + maxDiff);
    }


}
