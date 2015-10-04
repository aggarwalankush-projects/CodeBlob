package ArraysStrings;

public class RunLengthEncoding {

    public static void main(String[] args) {
        System.out.println("Compress the string:");
        System.out.println("aabbbbcffff -> "+compress("aabbbbcffff"));
        System.out.println("crazy -> "+compress("crazy"));
    }


    /**
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public static String compress(String input) {
        if (input == null || input.trim().length() == 0)
            return input;
        StringBuilder result = new StringBuilder();

        char previous = input.charAt(0);
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == previous) {
                count++;
            } else {
                result.append(previous).append(count);
                previous = input.charAt(i);
                count = 1;
            }
        }

        result.append(previous).append(count);

        if (result.length() > input.length())
            return input;
        else
            return result.toString();
    }


}
