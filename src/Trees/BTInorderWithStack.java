package Trees;

import java.util.ArrayList;
import java.util.Stack;
//@formatter:off
 /**
 * Given a binary tree, print inorder without using recursion.
 *
 *       10
 *     /   \
 *    17    13
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

 public class BTInorderWithStack {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBinaryTree(10, 17, 13, 3, 9, null, 16);
         ArrayList<Integer> list = new ArrayList<>();
         inorder(root, list);
         System.out.println("Inorder of Binary Tree: " + list);
     }


     public static void inorder(TreeNode root, ArrayList<Integer> list) {
         if (root == null)
             return;
         Stack<TreeNode> stack = new Stack<>();
         TreeNode current = root;
         while (current != null || !stack.isEmpty()) {
             if (current != null) {
                 stack.push(current);
                 current = current.left;
             } else if (!stack.isEmpty()) {
                 current = stack.pop();
                 list.add(current.data);
                 current = current.right;
             }
         }
     }

 }

