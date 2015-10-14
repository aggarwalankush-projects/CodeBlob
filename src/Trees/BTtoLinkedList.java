package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
//@formatter:off
/**
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes at
 * each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on
public class BTtoLinkedList {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
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
}

