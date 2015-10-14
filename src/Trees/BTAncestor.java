package Trees;

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

public class BTAncestor {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
        TreeNode node1 = TreeUtils.findBinaryTree(root, 10);
        TreeNode node2 = TreeUtils.findBinaryTree(root, 16);
        System.out.println("First common ancestor of " + node1 + " and " + node2 + ": " + ancestor(root, node1, node2));
        node1 = TreeUtils.findBinaryTree(root, 3);
        node2 = TreeUtils.findBinaryTree(root, 9);
        System.out.println("First common ancestor of " + node1 + " and " + node2 + ": " + ancestor(root, node1, node2));
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

}

