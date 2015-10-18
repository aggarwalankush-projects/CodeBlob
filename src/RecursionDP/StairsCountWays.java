package RecursionDP;

/**
 * Count the possible number of ways to climb N stairs.
 * Given you can hop either 1, 2 or 3 steps at a time.
 */
public class StairsCountWays {

    public static void main(String[] args) {
        int[] possibleWays = new int[30];
        System.out.println("Possible ways to climb " + 2 + " stairs: " + countWays(3, possibleWays));
        System.out.println("Possible ways to climb " + 5 + " stairs: " + countWays(5, possibleWays));
    }

    public static int countWays(int n, int[] possibleWays) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;
        if (possibleWays[n] != 0)
            return possibleWays[n];
        possibleWays[n] = countWays(n - 1, possibleWays) + countWays(n - 2, possibleWays) + countWays(n - 3, possibleWays);
        return possibleWays[n];
    }
}
