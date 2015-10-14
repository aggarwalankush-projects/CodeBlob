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

public class BTAncestorOptimized {
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
        Result result = findAncestor(root, p, q);
        return result.isAncestor ? result.node : null;
    }

    public static Result findAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Result(null, false);
        if (root == p && root == q)
            return new Result(root, true);
        Result leftSide = findAncestor(root.left, p, q);
        if (leftSide.isAncestor)
            return leftSide;
        Result rightSide = findAncestor(root.right, p, q);
        if (rightSide.isAncestor)
            return rightSide;

        if (leftSide.node != null && rightSide.node != null)
            return new Result(root, true);
        else if (root == p || root == q) {
            boolean isAncestor = leftSide.node != null || rightSide.node != null;
            return new Result(root, isAncestor);
        } else
            return new Result(leftSide.node != null ? leftSide.node : rightSide.node, false);
    }

}

class Result {
    public TreeNode node;
    public boolean isAncestor;

    public Result(TreeNode node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

