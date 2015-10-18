package RecursionDP;

import java.util.Arrays;

/**
 * Given a sorted array A, find the special index i such that
 * A[i] = i
 */
public class ArrayFindIndexSameAsValue {

    public static void main(String[] args) {
        int[] noDupArray = {-2, 0, 1, 3, 4, 5, 7};
        int[] dupArray = {1, 2, 2, 4, 5, 5, 7};
        System.out.println("Input Array with no duplicates: " + Arrays.toString(noDupArray));
        int index = findSpecialIndex(noDupArray);
        if (index != -1)
            System.out.println("Special Index and Value: " + index);
        else
            System.out.println("Special index not found");
        System.out.println("Input Array with duplicates: " + Arrays.toString(dupArray));
        index = findSpecialIndexDup(dupArray);
        if (index != -1)
            System.out.println("Special Index and Value: " + index);
        else
            System.out.println("Special index not found");
    }

    /**
     * Time Complexity: O(logN)
     */
    public static int findSpecialIndex(int[] array) {
        return findSpecialIndex(array, 0, array.length - 1);
    }

    public static int findSpecialIndex(int[] array, int low, int high) {
        if (low < 0 || high >= array.length || low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (array[mid] == mid)
            return mid;
        else if (array[mid] < mid)
            return findSpecialIndex(array, mid + 1, high);
        else
            return findSpecialIndex(array, low, mid - 1);
    }

    public static int findSpecialIndexDup(int[] array) {
        return findSpecialIndexDup(array, 0, array.length - 1);
    }

    public static int findSpecialIndexDup(int[] array, int low, int high) {
        if (low < 0 || high >= array.length || low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (array[mid] == mid)
            return mid;
        int leftResult = findSpecialIndexDup(array, low, Math.min(mid - 1, array[mid]));
        if (leftResult != -1)
            return leftResult;
        return findSpecialIndexDup(array, Math.max(mid + 1, array[mid]), high);
    }

}
