package ArraysStrings;

public class UniqueCharacterString {

    public static void main(String[] args) {
        System.out.println(isUniqueChar("ball"));
        System.out.println(isUniqueChar("racket"));
    }

    /**
     * Time complexity: O(n)
     * Space complexity: O(1)
     */
    public static boolean isUniqueChar(String input) {
        if (input == null || input.length() > 256)
            return false;
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (charSet[c])
                return false;
            else
                charSet[c] = true;
        }
        return true;
    }

}
