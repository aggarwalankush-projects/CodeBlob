package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an unsorted array,find the smallest subarray arr[i..j]
 * such that sorting this subarray makes the whole array sorted.
 */
public class MinLenUnsortedSubarray {

    public static void main(String[] args) {
        int[] array1 = {1, 4, 6, 7, 5, 9, 4, 12};
        System.out.println("Input Array: " + Arrays.toString(array1));
        findSubarray(array1);
        int[] array2 = {1, 2, 3, 4, 5, 6};
        System.out.println("\nInput Array: " + Arrays.toString(array2));
        findSubarray(array2);
    }

    /**
     * Time Complexity: O(n)
     */
    public static void findSubarray(int[] array) {

        int start, end;
        for (start = 0; start < array.length - 1; start++) {
            if (array[start] > array[start + 1])
                break;
        }
        if (start == array.length - 1) {
            System.out.println("Array already sorted");
            return;
        }
        for (end = array.length - 1; end > 0; end--) {
            if (array[end] < array[end - 1])
                break;
        }

        int min = array[start], max = array[end];
        for (int i = start + 1; i <= end; i++) {
            if (array[i] < min)
                min = array[i];
            if (array[i] > max)
                max = array[i];
        }

        for (int i = 0; i < start; i++) {
            if (array[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = array.length - 1; i > end; i--) {
            if (array[i] < max) {
                end = i;
                break;
            }
        }

        System.out.print("Indexes : " + start + ", " + end + " and Unsorted subarray: ");
        printArray(array, start, end);

    }

    private static void printArray(int[] array, int start, int end) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(array[i]);
        }
        System.out.println(list);
    }

}
