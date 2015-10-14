package Arrays;

import java.util.Arrays;

/**
 * Given an array where every element occurs three times,
 * except one element which occurs only once. Find the element that occurs once.
 */
public class ElementAppearedOnce {

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 6, 5, 6, 6};
        System.out.println("Input Array: " + Arrays.toString(array));
        System.out.println("Element Appeared Once -> " + findUniqueElement(array));

    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int findUniqueElement(int[] array) {

        int result = 0;
        int sum, x;
        for (int i = 0; i < 32; i++) {
            sum = 0;
            x = 1 << i;
            for (int elem : array)
                sum += elem & x;
            if (sum % 3 != 0)
                result |= x;
        }

        return result;
    }


}
