package TreesGraphs;

import java.util.ArrayList;
import java.util.Collections;
//@formatter:off
/**
 * Given a Binary Tree, convert it to a Binary Search Tree.
 * The conversion must be done in such a way that keeps the original structure of Binary Tree
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

public class BTtoBST {
    public static void main(String[] args) {
        TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        Collections.sort(list);
        TreeNode newRoot = TreeUtils.createBST(listToArray(list));
        System.out.println("Root of BST is " + newRoot);
    }

    public static void inorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static int[] listToArray(ArrayList<Integer> list) {
        int[] array = new int[list.size()];
        int j = 0;
        for (int i : list) array[j++] = i;
        return array;
    }
}

