package Strings;

import java.util.Arrays;

/**
 *  The longest repeated substring problem is the problem of
 *  finding the longest substring of a string that occurs at least twice.
 */
public class LongestRepeatedSubString {

    public static void main(String[] args) {
        System.out.println("Longest Repeated SubString of a String: ");
        System.out.println("banana -> " + lrs("banana"));
        System.out.println("javabeancoffeebean -> " + lrs("javabeancoffeebean"));
    }

    /**
     * Time Complexity: O(n)
     */
    public static String lrs(String input) {
        if (input == null || input.trim().length() == 0)
            return input;
        int strLen = input.length();
        //form N suffixes
        String[] suffixes = new String[strLen];
        for (int i = 0; i < strLen; i++) {
            suffixes[i] = input.substring(i);
        }
        String result = "";
        //sort suffixes
        Arrays.sort(suffixes);
        for (int i = 0; i < strLen - 1; i++) {
            // find longest repeated substring by comparing adjacent sorted suffixes
            String temp = lcp(suffixes[i], suffixes[i + 1]);
            if (result.length() < temp.length())
                result = temp;
        }
        return result;
    }

    /**
     * Find longest common prefix of two strings
     */
    private static String lcp(String first, String second) {
        int minLen = Math.min(first.length(), second.length());
        for (int i = 0; i < minLen; i++) {
            if (first.charAt(i) != second.charAt(i))
                return first.substring(0, i);
        }
        return first.substring(0, minLen);
    }

}
