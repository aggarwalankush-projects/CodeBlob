package RecursionDP;

import java.util.ArrayList;

/**
 * Find Permutation of a string
 */
public class Permutation {

    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Input String: " + input);
        System.out.println("Permutation: " + findPermutation(input));
    }

    /**
     * Time Complexity: O(N!)
     */
    public static ArrayList<String> findPermutation(String input) {
        ArrayList<String> list = new ArrayList<>();
        findPermutation("", input, list);
        return list;
    }

    private static void findPermutation(String prefix, String input, ArrayList<String> list) {
        int len = input.length();
        if (len == 0)
            list.add(prefix);
        else
            for (int i = 0; i < len; i++)
                findPermutation(prefix + input.charAt(i), input.substring(0, i) + input.substring(i + 1, len), list);
    }
}
