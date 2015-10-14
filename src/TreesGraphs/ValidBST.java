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

public class ValidBST {
    public static void main(String[] args) {
        TreeNode root = createTree();
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


    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(13);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node6 = new TreeNode(16);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;
        return root;
    }
}

