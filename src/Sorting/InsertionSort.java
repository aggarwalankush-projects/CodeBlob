package Sorting;

import java.util.Arrays;

/**
 * Sort a given integer array
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Input array : " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array : " + Arrays.toString(array));
    }

    /**
     * Time Complexity: O(N^2)
     */
    private static void sort(int[] array) {
        int i, j, temp;
        for (i = 1; i < array.length; i++) {
            temp = array[i];
            for (j = i - 1; j >= 0 && temp < array[j]; j--)
                array[j + 1] = array[j];
            array[j + 1] = temp;
        }
    }

}
