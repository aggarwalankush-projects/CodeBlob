package Trees;

import java.util.ArrayList;
//@formatter:off
/**
 * Given a binary tree, find the distance between 2 given nodes.
 * Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 */
//@formatter:on

public class BTDistanceBetweenNodes {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
        TreeNode node1 = TreeUtils.findBinaryTree(root, 9);
        TreeNode node2 = TreeUtils.findBinaryTree(root, 1);
        System.out.println("Distance between " + node1 + " and " + node2 + ": " + findDistance(root, node1, node2));
    }

    public static int findDistance(TreeNode root, TreeNode node1, TreeNode node2) {
        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();
        boolean foundNode1 = findPath(root, node1, path1);
        boolean foundNode2 = findPath(root, node2, path2);
        if (!foundNode1 || !foundNode2)
            return -1;
        int index;
        for (index = 0; index < path1.size(); index++) {
            if (path1.get(index) != path2.get(index))
                break;
        }
        return path1.size() + path2.size() - 2 * index;

    }

    private static boolean findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path) {
        if (root == null)
            return false;
        path.add(root);
        if (root.data == node.data)
            return true;
        if (findPath(root.left, node, path) || findPath(root.right, node, path))
            return true;
        path.remove(root);
        return false;
    }

}

