package TreesGraphs;

import java.util.Stack;
//@formatter:off
 /**
 * Find a pair with given sum in a BST
 *
 *       10
 *     /   \
 *    7     13
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

 public class BSTSumK {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBST(3, 7, 9, 10, 13, 16);
         findPairOfSumK(root, 16);
     }

     public static void findPairOfSumK(TreeNode root, int k) {
         TreeNode a = root;
         TreeNode b = root;
         Stack<TreeNode> aStack = new Stack<>();
         Stack<TreeNode> bStack = new Stack<>();
         while (a.left != null) {
             aStack.push(a);
             a = a.left;
         }
         while (b.right != null) {
             bStack.push(b);
             b = b.right;
         }

         while (a.data < b.data) {
             if (a.data + b.data == k) {
                 System.out.println("Pair of sum = " + k + ": (" + a + ", " + b + ")");
                 return;
             } else if (a.data + b.data < k) {
                 if (a.right != null) {
                     a = a.right;
                     while (a.left != null) {
                         aStack.push(a);
                         a = a.left;
                     }
                 } else
                     a = aStack.pop();
             } else {
                 if (b.left != null) {
                     b = b.left;
                     while (b.right != null) {
                         bStack.push(b);
                         b = b.right;
                     }
                 } else
                     b = bStack.pop();
             }
         }
         System.out.println("No Pair found for sum = " + k);

     }
 }

