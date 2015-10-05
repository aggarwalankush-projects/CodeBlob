package ArraysStrings;

import java.util.Arrays;

/**
 * Equilibrium index of an array is an index such that
 * the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
 */
public class EquilibriumIndex {

    public static void main(String[] args) {
        int[] array = {7, 1, 3, 1, 1, 6, 4};
        System.out.println("Input Array:");
        System.out.println(Arrays.toString(array));
        System.out.println("Equilibrium index and element:");
        findEquilibrium(array);
    }

    /**
     * Time Complexity: O(n)
     */
    public static void findEquilibrium(int[] array) {
        int sum = 0;
        for (int i : array)
            sum += i;
        int leftSum = 0;
        for (int i = 0; i < array.length; i++) {
            sum -= array[i];
            if (sum == leftSum) {
                System.out.println("Index: " + i + ", Element: " + array[i]);
                return;
            }
            leftSum += array[i];
        }

        System.out.println("None");
    }
}
