package Arrays;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an integer array and a positive integer K,
 * count all distinct pairs with difference equal to K.
 */
public class CountDifferencePair {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Number of Pairs of difference equals K:");
        System.out.println("Input: " + Arrays.toString(array) + ", K = 2");
        System.out.println("Pair count: " + countDifferencePair(array, 2));
    }

    /**
     * Time Complexity: O(N)
     */
    private static int countDifferencePair(int[] array, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int elem : array)
            set.add(elem);

        int pairCount = 0;
        for (int elem : array) {
            if (set.contains(elem - k) || set.contains(elem + k))
                pairCount++;
            set.remove(elem);
        }
        return pairCount;
    }
}
