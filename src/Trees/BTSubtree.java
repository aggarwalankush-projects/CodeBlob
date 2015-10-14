package Trees;

//@formatter:off
/**
 * We have two binary trees: T1 and T2
 * Find if T2 is a subtree of T1.
 *
 * T1 -> 10        T2 -> 17
 *     /   \            /  \
 *    17    1          3    9
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class BTSubtree {
    public static void main(String[] args) {
        TreeNode t1 = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
        TreeNode t2 = TreeUtils.createBinaryTree(17, 3, 9);
        System.out.println("Is T2 subtree of T1: " + isSubTree(t1, t2));
    }

    /**
     * Time Complexity: O(n + km)
     * Space Complexity: O(log(n) + log(m))
     * n - size of T1
     * m - size of T2
     * k - occurrences of T2 root in T1
     */
    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        return contains(t1, t2);
    }

    private static boolean contains(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return false;
        if (t1.data == t2.data)
            return match(t1, t2);
        return contains(t1.left, t2) || contains(t1.right, t2);
    }

    private static boolean match(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.data != t2.data)
            return false;
        return match(t1.left, t2.left) && match(t1.right, t2.right);
    }
}

