package TreesGraphs;

//@formatter:off
/**
 * Check if a binary tree is balanced.
 * A binary tree is balanced if the heights of the two subtrees of any node
 * never differ by more than one.
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class BTBalanced {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
        System.out.println("Is binary tree balanced: " + isBalanced(root));
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(H), H - height of tree
     */
    private static boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = getHeight(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = getHeight(root.right);
        if (rightHeight == -1)
            return -1;

        int heightDiff = Math.abs(leftHeight - rightHeight);
        if (heightDiff > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

}

