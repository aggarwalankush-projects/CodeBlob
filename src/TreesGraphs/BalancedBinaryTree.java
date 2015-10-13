package TreesGraphs;

//@formatter:off
/**
 * Check if a binary tree is balanced.
 * A binary tree is balanced if the heights of the two subtrees of any node
 * never differ by more than one.
 *
 *       10
 *     /   \
 *    7     8
 *   / \   / \
 *  3   9 4   6
 *
 */
//@formatter:on

public class BalancedBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(isBalanced(root));
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

