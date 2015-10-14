package TreesGraphs;

import java.util.Stack;
//@formatter:off
 /**
 * Find median in a given BST
 *      10
 *     /  \
 *    7   13
 *   / \  / \
 *  3  9 11 16
 **/
//@formatter:on

 public class BSTMedian {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBST(3, 7, 9, 10, 11, 13, 16);
         System.out.println("Median of given BST: " + findMedian(root, 6));
     }

     public static Double findMedian(TreeNode root, int size) {
         if (root == null)
             return null;
         boolean even = size % 2 == 0;
         int mid = size / 2;
         int median = 0, count = 0;
         TreeNode current = root;
         Stack<TreeNode> stack = new Stack<>();
         while (current != null || !stack.isEmpty()) {
             if (current != null) {
                 stack.push(current);
                 current = current.left;
             } else {
                 current = stack.pop();
                 if (even && count == mid - 1)
                     median = current.data;
                 else if (count == mid) {
                     median += current.data;
                     break;
                 }
                 count++;
                 current = current.right;
             }
         }
         return even ? median / 2.0 : median;
     }
 }

