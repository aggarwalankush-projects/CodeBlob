package Sorting;

import java.util.Arrays;

/**
 * Sort a given integer array
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {7, 3, 5, 9, 1, 6, 4};
        System.out.println("Input array : " + Arrays.toString(array));
        sort(array);
        System.out.println("Sorted array : " + Arrays.toString(array));
    }

    /**
     * Time Complexity:
     * average - O(N*log(N))
     * worst - O(N^2)
     */
    private static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high){
        int index = partition(array, low, high);
        if(low<index-1)
            quickSort(array, low, index - 1);
        if (index < high)
            quickSort(array,index,high);
    }

    private static int partition(int[] array, int low, int high){
        int pivot = array[(low + high) / 2];
        while(low<=high){
            while (array[low]<pivot)
                low++;
            while(array[high]>pivot)
                high--;
            if(low<=high){
                swap(array,low,high);
                low++;
                high--;
            }
        }
        return low;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
