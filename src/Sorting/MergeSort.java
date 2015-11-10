package Sorting;

import java.util.Arrays;

/**
 * Sort a given integer array
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Input array : " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array : " + Arrays.toString(array));
    }

    /**
     * Time Complexity: O(N*log(N))
     */
    private static void sort(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(array, helper, low, mid);
            mergeSort(array, helper, mid + 1, high);
            merge(array, helper, low, mid, high);
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high) {
        System.arraycopy(array, low, helper, low, high - low + 1);

        int left = low;
        int right = mid + 1;
        int current = low;

        while (left <= mid && right <= high) {
            if (helper[left] <= helper[right]) {
                array[current] = helper[left];
                left++;
            } else {
                array[current] = helper[right];
                right++;
            }
            current++;
        }

        System.arraycopy(helper, left, array, current, mid - left + 1);
    }
}
