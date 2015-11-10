package RecursionDP;


/**
 * Given two strings, find the longest common substring.
 * It's the longest string that is a substring of two strings.
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        String first = "ABABC";
        String second = "ABCBA";
        String lcs = findLCS(first, second);
        System.out.println("Input String 1 : " + first);
        System.out.println("Input String 2 : " + second);
        System.out.println("Longest common substring : " + lcs);
    }


    private static String findLCS(String first, String second) {
        int M = first.length();
        int N = second.length();
        int[][] array = new int[M + 1][N + 1];
        int maxLen=0, endPos=-1;

        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <=N; j++) {
                if(first.charAt(i-1)==second.charAt(j-1)){
                    array[i][j]=array[i-1][j-1]+1;
                    if(array[i][j]>maxLen){
                        maxLen=array[i][j];
                        endPos=i;
                    }
                }else
                    array[i][j]=0;
            }
        }

        return first.substring(endPos-maxLen,endPos);

    }
}
