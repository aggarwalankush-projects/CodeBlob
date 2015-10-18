package RecursionDP;

import java.util.ArrayList;

/**
 * Find all valid combinations of N-pairs of parentheses
 */
public class ValidParentheses {

    public static void main(String[] args) {
        int N = 3;
        System.out.println("Valid Parentheses for N=" + N + ": " + findParentheses(N));
    }

    public static ArrayList<String> findParentheses(int n) {
        ArrayList<String> list = new ArrayList<>();
        findParentheses(n, n, new char[2 * n], 0, list);
        return list;
    }

    private static void findParentheses(int left, int right, char[] buffer, int count, ArrayList<String> list) {
        if (left < 0 || left > right)
            return;
        if (left == 0 && right == 0)
            list.add(String.copyValueOf(buffer));
        else {
            if (left > 0) {
                buffer[count] = '(';
                findParentheses(left - 1, right, buffer, count + 1, list);
            }
            if (right > left) {
                buffer[count] = ')';
                findParentheses(left, right - 1, buffer, count + 1, list);
            }
        }
    }
}
