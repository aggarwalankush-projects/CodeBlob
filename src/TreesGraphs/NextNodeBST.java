package TreesGraphs;

//@formatter:off
/**
 * Find the 'next'node (i.e., in-order successor) of a given node
 * in a binary search tree.
 * Assumption: Each node has an additional link to its parent.
 *
 *       10
 *     /   \
 *    7     13
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class NextNodeBST {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("Next Node of " + root + ": " + nextNodeBST(root));
        System.out.println("Next Node of " + root.right.right + ": " + nextNodeBST(root.right.right));
        System.out.println("Next Node of " + root.left.right + ": " + nextNodeBST(root.left.right));
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


    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(13);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node6 = new TreeNode(16);
        root.left = node1;
        root.right = node2;
        node1.parent = root;
        node2.parent = root;
        node1.left = node3;
        node1.right = node4;
        node3.parent = node1;
        node4.parent = node1;
        node2.right = node6;
        node6.parent = node2;
        return root;
    }
}

