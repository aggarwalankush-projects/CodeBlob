package RecursionDP;


import java.util.Arrays;

/**
 * Given an infinite supply of each of V = {V1, V2 ..Vn} valued coins
 * find ways to change K cents
 * for eg, if K = 4 and V = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
 * So output should be 4.
 */
public class CoinDenomination_aka_KnapSackWithRepetition {

    public static void main(String[] args) {
        int[] input = {1, 2, 3};
        int k = 4;
        System.out.println("Input coin values : " + Arrays.toString(input));
        System.out.println("Ways to change " + k + " cents : " + findWays(input, k));
    }

    private static int findWays(int[] coins, int k) {
        int[] ways = new int[k + 1];
        ways[0] = 1;

        for (int coinVal : coins)
            for (int j = coinVal; j <= k; j++)
                ways[j] += ways[j - coinVal];

        return ways[k];
    }

}
