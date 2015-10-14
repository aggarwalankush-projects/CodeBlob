package TreesGraphs;

//@formatter:off
/**
 * Check if a binary tree is a binary search tree.
 *
 *       10
 *     /   \
 *    7     13
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class BSTValid {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 7, 13, 3, 9, null, 16);
        System.out.println("Is valid BST: " + isValidBST(root));
    }

    /**
     * Time Complexity: O(log(N))
     */
    private static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isValidBST(TreeNode root, int min, int max) {
        if (root == null)
            return true;

        if (root.data <= min || root.data > max)
            return false;

        if (!isValidBST(root.left, min, root.data) || !isValidBST(root.right, root.data, max))
            return false;

        return true;
    }

}

