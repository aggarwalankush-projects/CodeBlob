package Sorting;

import java.util.Arrays;

/**
 * Sort a given integer array
 */
public class SelectionSort {

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
        for (int i = 0; i < array.length - 1; i++) {
            int smallIndex = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[smallIndex])
                    smallIndex = j;

            swap(array, i, smallIndex);
        }
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
