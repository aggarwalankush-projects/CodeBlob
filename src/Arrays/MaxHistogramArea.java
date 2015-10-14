package Arrays;

import java.util.Arrays;
import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram
 * Rectangle can only be made of contiguous bars
 * Assumptions: All bars are of width 1
 */
public class MaxHistogramArea {

    public static void main(String[] args) {
        int[] height = {10, 9, 5, 6, 8, 11, 10};
        System.out.println("Input Array: " + Arrays.toString(height));
        System.out.println("Max Difference: " + findMaxHistogramArea(height));
    }

    /**
     * Time Complexity: O(n)
     */
    public static int findMaxHistogramArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        int i = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] >= height[stack.peek()])
                stack.push(i++);
            else {
                int hyt = height[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, hyt * width);
            }
        }
        while (!stack.isEmpty()) {
            int hyt = height[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, hyt * width);
        }
        return maxArea;
    }


}
