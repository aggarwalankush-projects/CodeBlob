package ArraysStrings;

import java.util.Arrays;

public class ValidPermutation {

    public static void main(String[] args) {
        System.out.println("Valid Permutaiton:");
        System.out.println("ball and labl -> " + validPermutation1("ball", "labl"));
        System.out.println("racket and traced -> " + validPermutation1("racket", "traced"));
        System.out.println("ball and labl -> " + validPermutation2("ball", "labl"));
        System.out.println("racket and traced -> " + validPermutation2("racket", "traced"));
    }

    public static boolean validPermutation1(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;
        return sortString(first).equals(sortString(second));
    }

    private static String sortString(String input) {
        char[] c = input.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }

    public static boolean validPermutation2(String first, String second) {
        if (first == null || second == null || first.length() != second.length())
            return false;
        int[] charCount = new int[256];
        for (int i = 0; i < first.length(); i++) {
            charCount[first.charAt(i)]++;
        }
        for (int i = 0; i < second.length(); i++) {
            if (--charCount[second.charAt(i)] < 0)
                return false;
        }
        return true;
    }


}
