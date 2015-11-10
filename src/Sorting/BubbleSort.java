package Sorting;

import java.util.Arrays;

/**
 * Sort a given integer array
 */
public class BubbleSort {

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
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1])
                    swap(array, j, j + 1);
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
