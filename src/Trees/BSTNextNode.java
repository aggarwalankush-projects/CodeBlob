package Trees;

//@formatter:off
/**
 * Find the 'next'node (i.e., in-order successor) of a given node
 * in a binary search tree.
 * Assumption: Each node has an additional link to its parent.
 *
 *      10
 *     /  \
 *    7   13
 *   / \  / \
 *  3  9 11 16
 *
 */
//@formatter:on

public class BSTNextNode {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBST(3, 7, 9, 10, 11, 13, 16);
        System.out.println("Next Node of " + root + ": " + nextNodeBST(root));
        TreeNode node = TreeUtils.findBST(root, 16);
        System.out.println("Next Node of " + node + ": " + nextNodeBST(node));
        node = TreeUtils.findBST(root, 7);
        System.out.println("Next Node of " + node + ": " + nextNodeBST(node));
    }

    public static TreeNode nextNodeBST(TreeNode node) {
        if (node == null)
            return null;
        if (node.right != null)
            return leftMost(node.right);
        TreeNode prev = node;
        TreeNode parent = prev.parent;
        while (parent != null && parent.left != prev) {
            prev = parent;
            parent = parent.parent;
        }
        return parent;
    }

    private static TreeNode leftMost(TreeNode node) {
        if (node == null)
            return null;
        while (node.left != null)
            node = node.left;
        return node;
    }
}

