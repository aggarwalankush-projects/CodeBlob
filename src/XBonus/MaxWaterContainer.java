package XBonus;


import java.util.Arrays;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class MaxWaterContainer {

    public static void main(String[] args) {
        int[] height = {2, 4, 6, 4, 5, 4, 7, 4};
        System.out.println("Input heights : " + Arrays.toString(height));
        System.out.println("Max Area : " + maxArea(height));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }

}

