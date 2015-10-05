package ArraysStrings;

import java.util.Arrays;

public class MaxSubarraySum {

    public static void main(String[] args) {
        int[] array1 = {7, -3, 5, -9, 1, 6, -4};
        int[] array2 = {-7, -3, -2, -9, -1, -6, -4};
        System.out.println("Maximum contiguous subarray sum:");
        System.out.println(Arrays.toString(array1) + " -> " + findMax(array1));
        System.out.println(Arrays.toString(array2) + " -> " + findMax(array2));
    }


    private static Integer findMax(int[] array) {
        if (array == null || array.length < 1)
            return null;
        int max = array[0];
        int sum = array[0];
        //Ignore sum of previous elements if nth element is greater than the sum
        for (int i = 1; i < array.length; i++) {
            sum = Math.max(array[i], sum + array[i]);
            max = Math.max(sum, max);
        }
        return max;
    }

}
