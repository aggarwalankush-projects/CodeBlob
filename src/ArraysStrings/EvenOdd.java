package ArraysStrings;

import java.util.Arrays;

/**
 * You are given an array of positive numbers.
 * You have to rearrange array such that even numbers at even position and odd numbers at odd positions.
 * If suppose odd numbers exceeds the even numbers or vice-versa than keep them untouched.
 */
public class EvenOdd {

    public static void main(String[] args) {
        int[] array = {2, 5, 7, 8, 1, 6, 9, 1, 6};
        System.out.println("Input Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Rearranged Even at even index and Odd at odd index:");
        rearrange(array);
        System.out.println(Arrays.toString(array));
    }


    /**
     * Time Complexity: O(n)
     */
    private static void rearrange(int[] array) {
        if (array == null || array.length < 2)
            return;
        int evenPos = 0;
        int oddPos = 1;

        int len = array.length;
        while (true) {
            while (evenPos < len && array[evenPos] % 2 == 0)
                evenPos += 2;
            while (oddPos < len && array[oddPos] % 2 == 1)
                oddPos += 2;
            if (evenPos < len && oddPos < len)
                swap(array, evenPos, oddPos);
            else
                break;
        }

    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}
