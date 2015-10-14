package Strings;

/**
 * Given a string, find the longest substring which is palindrome.
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        System.out.println("Longest Palindromic SubString of a String: ");
        System.out.println("banana -> " + lps("banana"));
        System.out.println("javabeancoffeebean -> " + lps("javabeancoffeebean"));
    }

    /**
     * Time Complexity: O(N^2)
     */
    public static String lps(String input) {
        if (input == null || input.trim().length() == 0)
            return input;
        int strLen = input.length();
        if (strLen < 2)
            return input;

        String result = input.substring(0, 1);
        for (int i = 1; i < strLen; i++) {
            // get longest palindrome with center of i
            String temp = getPalindrome(input, i, i);
            if (result.length() < temp.length())
                result = temp;
            // get longest palindrome with center of i, i+1
            temp = getPalindrome(input, i, i + 1);
            if (result.length() < temp.length())
                result = temp;
        }
        return result;
    }

    /**
     * @param input - get palindrome from this string
     * @param begin - begin index
     * @param end   - end index
     *              if begin==end, we have a center eg. aba
     *              if begin==end-1, we don't have any center eg. abba
     * @return largest palindrome from input string
     */
    private static String getPalindrome(String input, int begin, int end) {
        int strLen = input.length();
        while (begin >= 0 && end < strLen && (input.charAt(begin) == input.charAt(end))) {
            begin--;
            end++;
        }
        return input.substring(begin + 1, end);
    }

}
