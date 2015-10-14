package Arrays;

import java.util.Arrays;

/**
 * Given an array find peak element.
 * Peak element is greater than its neighbours
 */
public class PeakElement {

    public static void main(String[] args) {
        int[] array = {10, 9, 5, 6, 8, 11, 10};
        System.out.println("Input Array: " + Arrays.toString(array));
        int peakIndex = findPeakElement(array, 0, array.length - 1);
        System.out.println("Peak Index: " + peakIndex + " and Element: " + array[peakIndex]);
    }

    /**
     * Time Complexity: O(log(n))
     */
    public static int findPeakElement(int[] array, int low, int high) {
        int mid = low + (high - low) / 2;
        if ((mid == 0 || array[mid] >= array[mid - 1]) && (mid == array.length - 1 || array[mid] > array[mid + 1]))
            return mid;
        else if (array[mid - 1] > array[mid])
            return findPeakElement(array, low, mid - 1);
        else
            return findPeakElement(array, mid + 1, high);
    }


}
