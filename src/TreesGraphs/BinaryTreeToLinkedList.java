package TreesGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
//@formatter:off
/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 *       10
 *     /   \
 *    7     8
 *   / \   / \
 *  3   9 4   6
 *
 */
//@formatter:on
public class BinaryTreeToLinkedList {
    public static void main(String[] args) {
        TreeNode root = createTree();
        ArrayList<LinkedList<TreeNode>> listOfLists = generateLists(root);
        System.out.println("List of LinkedLists: " + listOfLists);
    }

    /**
     * Time Complexity: O(N)
     */
    public static ArrayList<LinkedList<TreeNode>> generateLists(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if (root != null)
            current.add(root);
        while (!current.isEmpty()) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null)
                    current.add(parent.left);
                if (parent.right != null)
                    current.add(parent.right);
            }
        }
        return result;
    }

    public static TreeNode createTree() {
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
        return root;
    }
}

