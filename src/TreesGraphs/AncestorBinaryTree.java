package TreesGraphs;

//@formatter:off
/**
 * Find the first common ancestor of two nodes in a Binary Tree.
 * Binary tree is NOT necessarily a Binary search Tree.
 * Assumption: NO parent links
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class AncestorBinaryTree {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("First common ancestor of " + root + " and " + root.right + ": " + ancestor(root, root, root.right));
        System.out.println("First common ancestor of " + root.left.left + " and " + root.left.right + ": " + ancestor(root, root.left.left, root.left.right));
    }


    public static TreeNode ancestor(TreeNode root, TreeNode p, TreeNode q) {
        if (!contains(root, p) || !contains(root, q))
            return null;
        return findAncestor(root, p, q);

    }

    private static TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q)
            return root;

        boolean is_p_on_left = contains(root.left, p);
        boolean is_q_on_left = contains(root.left, q);
        if (is_p_on_left != is_q_on_left)
            return root;

        TreeNode whichSide = is_p_on_left ? root.left : root.right;
        return findAncestor(whichSide, p, q);
    }

    private static boolean contains(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return contains(root.left, node) || contains(root.right, node);
    }


    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(17);
        TreeNode node2 = new TreeNode(1);
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

