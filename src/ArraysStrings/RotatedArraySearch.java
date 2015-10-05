package ArraysStrings;

import java.util.Arrays;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand
 * Search an element K in rotated array
 */
public class RotatedArraySearch {

    public static void main(String[] args) {
        int[] array = {5, 5, 6, 7, 1, 2, 3, 4};
        System.out.println("Search in Rotated Array:");
        System.out.print("Input: " + Arrays.toString(array) + ", K = 7 -> ");
        int index = search(array, 0, array.length - 1, 7);
        if (index == -1)
            System.out.println("Not found");
        else
            System.out.println("Found at index " + index);
    }

    /**
     * Time Complexity: O(log(N))
     */
    private static int search(int[] array, int low, int high, int key) {
        int mid = low + (high - low) / 2;
        if (array[mid] == key)
            return mid;
        while (low <= high) {
            if (array[low] < array[mid]) {
                if (array[low] <= key && key < array[mid])
                    return search(array, low, mid - 1, key);
                else
                    return search(array, mid + 1, high, key);
            } else if (array[low] > array[mid]) {
                if (array[mid] < key && key <= array[high])
                    return search(array, mid + 1, high, key);
                else
                    return search(array, low, mid - 1, key);
            } else if (array[low] == array[mid]) {
                if (array[mid] != array[high])
                    return search(array, mid + 1, high, key);
                else {
                    int result = search(array, low, mid - 1, key);
                    return result != -1 ? result : search(array, mid + 1, high, key);
                }
            }
        }
        return -1;
    }

}
