package RecursionDP;


/**
 * Given two strings, find the length of longest subsequence common to both strings.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * for eg. "abc", "ac", "b" are some subsequences of string "abc"
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String first = "ACBDEGCEDGB";
        String second = "BEGCFEUBK";
        String lcs = findLCS(first, second);
        System.out.println("Input String 1 : " + first);
        System.out.println("Input String 2 : " + second);
        System.out.println("Longest common subsequence : " + lcs);
    }


    private static String findLCS(String first, String second) {
        int M = first.length();
        int N = second.length();
        int[][] array = new int[M + 1][N + 1];

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (first.charAt(i) == second.charAt(j))
                    array[i][j] = array[i + 1][j + 1] + 1;
                else
                    array[i][j] = Math.max(array[i + 1][j], array[i][j + 1]);
            }
        }

        StringBuilder result = new StringBuilder();

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (first.charAt(i) == second.charAt(j)) {
                result.append(first.charAt(i));
                i++;
                j++;
            } else if (array[i + 1][j] >= array[i][j + 1])
                i++;
            else
                j++;
        }

        return result.toString();

    }
}
