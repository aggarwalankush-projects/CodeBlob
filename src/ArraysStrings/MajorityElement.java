package ArraysStrings;

import java.util.Arrays;
import java.util.Stack;

/**
 * A majority element in an array of size N is an element
 * that appears more than N/2 times
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] array = {10, 9, 5, 2, 5, 5, 5};
        System.out.println("Input Array: " + Arrays.toString(array));
        findMajorityElement(array);
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void findMajorityElement(int[] array) {
        int count = 1;
        int majorityIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[majorityIndex])
                count++;
            else
                count--;
            if (count == 0) {
                majorityIndex = i;
                count = 1;
            }
        }

        if (isMajority(array, array[majorityIndex]))
            System.out.println("Majority Element: " + array[majorityIndex]);
        else
            System.out.println("No Majority Element Found");
    }

    private static boolean isMajority(int[] array, int elem) {
        int count = 0;
        for (int i : array)
            if (i == elem)
                count++;
        return count > array.length / 2;
    }


}
