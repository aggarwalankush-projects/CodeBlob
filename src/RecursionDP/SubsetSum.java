package RecursionDP;


import java.util.Arrays;

/**
 * Given a set of non-negative integers, and a target K
 * Find if there exists a subset with sum equals to K.
 */
public class SubsetSum {

    public static void main(String[] args) {
        int[] input = {8, 3, 5, 11, 4, 9};
        int k = 7;
        System.out.println("Input Array : " + Arrays.toString(input));
        System.out.println("Is Subset of sum " + k + " exists? " + findSubset(input, k));
    }


    private static boolean findSubset(int[] array, int k) {
        int arrLen = array.length;
        boolean[][] subset = new boolean[k + 1][arrLen + 1];
        for (int i = 0; i <= arrLen; i++)
            subset[0][i] = true;
        for (int i = 1; i <= k; i++)
            subset[i][0] = false;

        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= arrLen; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= array[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - array[j - 1]][j - 1];
                }
            }
        }
        return subset[k][arrLen];
    }
}
