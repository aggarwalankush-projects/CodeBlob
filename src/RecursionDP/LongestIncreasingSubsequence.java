package RecursionDP;


import java.util.Arrays;

/**
 * Given an integer array, find the longest increasing subsequence
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] input = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println("Input Array : " + Arrays.toString(input));
        findLIS(input);
    }

    private static void findLIS(int[] array) {
        int arrLen = array.length;
        String[] paths = new String[arrLen];
        int[] L = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            L[i] = 1;
            paths[i] = array[i] + " ";
        }

        int maxLen = 1;
        for (int i = 1; i < arrLen; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j] && L[i] < L[j] + 1) {
                    L[i] = L[j] + 1;
                    paths[i] = paths[j] + array[i] + " ";
                    maxLen = Math.max(maxLen, L[i]);
                }
            }
        }

        for (int i = 0; i < arrLen; i++) {
            if (L[i] == maxLen)
                System.out.println("LIS : " + paths[i]);
        }

    }
}
