package Strings;

/**
 * Given a string Source and a string Target,
 * find the minimum window in Source which will contain all the characters in Target
 */
public class MinimumWindowSubString {

    public static void main(String[] args) {
        System.out.println("Minimum window in Source having all elements of Target: ");
        System.out.println("banana and nba -> " + minWindow("banana", "nba"));
        System.out.println("aprilfool and roof -> " + minWindow("aprilfool", "roof"));
    }

    /**
     * Time Complexity: O(n)
     */
    public static String minWindow(String source, String target) {
        if (source == null || target == null || source.isEmpty() || target.isEmpty())
            return null;

        int sLen = source.length();
        int tLen = target.length();

        int[] needToFind = new int[256];
        int[] hasFound = new int[256];
        int minWinLen = Integer.MAX_VALUE;
        int minWinBegin = 0, minWinEnd = 0, count = 0;

        for (int i = 0; i < tLen; i++) {
            needToFind[target.charAt(i)]++;
        }

        for (int begin = 0, end = 0; end < sLen; end++) {
            char currentChar = source.charAt(end);
            // skip characters not in target
            if (needToFind[currentChar] == 0)
                continue;
            hasFound[currentChar]++;
            if (hasFound[currentChar] <= needToFind[currentChar])
                count++;
            // if window constraint is satisfied
            if (count == tLen) {
                // advance begin index as far right as possible,
                // stop when advancing breaks window constraint.
                while (needToFind[source.charAt(begin)] == 0 ||
                        hasFound[source.charAt(begin)] > needToFind[source.charAt(begin)]) {

                    if (hasFound[source.charAt(begin)] > needToFind[source.charAt(begin)])
                        hasFound[source.charAt(begin)]--;
                    begin++;
                }

                // update minWindow if a minimum length is met
                int winLen = end - begin + 1;
                if (minWinLen > winLen) {
                    minWinBegin = begin;
                    minWinEnd = end;
                    minWinLen = winLen;
                }
            }
        }

        return source.substring(minWinBegin, minWinEnd + 1);
    }


}
