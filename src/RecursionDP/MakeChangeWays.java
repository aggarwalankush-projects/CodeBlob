package RecursionDP;

/**
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent),
 * Find the number of ways of representing N cents.
 */
public class MakeChangeWays {

    public static void main(String[] args) {
        int N = 100;
        int biggest_denom = 25;
        System.out.println("Number of ways to represent " + N + " cents: " + findWays(N, biggest_denom));
    }

    public static int findWays(int N, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for (int i = 0; i * denom <= N; i++)
            ways += findWays(N - i * denom, next_denom);
        return ways;
    }
}
