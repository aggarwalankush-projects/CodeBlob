package StacksQueues;

import java.util.Arrays;

/**
 * Given an array, print the Next Smallest Element for every element.
 * The Next smallest Element for an element x is the first smallest element on the right side of x in array.
 * Elements for which no smallest element exist, consider next smallest element as -1.
 */
public class NextSmallest {

    public static void main(String[] args) {
        int[] array = {5, 8, 4, 1, 6};
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("Next Smallest Array: " + Arrays.toString(printNextSmallest(array)));
    }

    /**
     * Time Complexity: O(N)
     */
    private static int[] printNextSmallest(int[] array) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            while (!stack.isEmpty() && array[stack.peek()] > array[i])
                result[stack.pop()] = array[i];
            stack.push(i);
        }
        while (!stack.isEmpty())
            result[stack.pop()] = -1;
        return result;
    }
}



