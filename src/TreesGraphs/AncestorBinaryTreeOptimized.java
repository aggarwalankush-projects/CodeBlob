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

public class AncestorBinaryTreeOptimized {
    public static void main(String[] args) {
        TreeNode root = createTree();
        System.out.println("First common ancestor of " + root + " and " + root.right + ": " + ancestor(root, root, root.right));
        System.out.println("First common ancestor of " + root.left.left + " and " + root.left.right + ": " + ancestor(root, root.left.left, root.left.right));
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

class Result {
    public TreeNode node;
    public boolean isAncestor;

    public Result(TreeNode node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}

