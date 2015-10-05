package ArraysStrings;

import java.util.*;

/**
 * Given an array of integers, sort the array according to frequency of elements.
 */
public class SortByFrequency {

    public static void main(String[] args) {
        int[] array = {3, 3, 1, 1, 1, 5, 5, 5, 5, 5, 3, 6, 6};
        System.out.println("Input Array: " + Arrays.toString(array));
        frequencySort(array);
        System.out.println("Sorted By Frequency: " + Arrays.toString(array));
    }


    private static void frequencySort(int[] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int elem : array) {
            if (map.containsKey(elem))
                map.put(elem, map.get(elem) + 1);
            else
                map.put(elem, 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        int index = 0;
        for (Map.Entry<Integer, Integer> entry : list) {
            int elem = entry.getKey();
            int frequency = entry.getValue();
            while (frequency-- > 0)
                array[index++] = elem;
        }
    }


}
