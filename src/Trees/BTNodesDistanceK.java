package Trees;

import java.util.ArrayList;
//@formatter:off
 /**
 * Given a binary tree, find all nodes at distance K from given node
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *     / \
  *   4  14
 */
//@formatter:on

 public class BTNodesDistanceK {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16, null, null, 4, 14);
         TreeNode node = TreeUtils.findBinaryTree(root, 17);
         int k = 2;
         System.out.println("Nodes at distance " + k + " from node " + node + ": " + findNodes(root, node, k));
     }

     public static ArrayList<TreeNode> findNodes(TreeNode root, TreeNode node, int k) {
         ArrayList<TreeNode> list = new ArrayList<>();
         traverse(root, node, k, list);
         return list;
     }

     /**
      * Return how far the target node is from the current root
      */
     private static int traverse(TreeNode root, TreeNode target, int k, ArrayList<TreeNode> list) {
         if (root == null || target == null || k < 0)
             return -1;
         if (root == target) {
             traverseDown(target, k, list);
             return 0;
         }
         int leftDistance = traverse(root.left, target, k, list);
         if (leftDistance != -1) {
             if (leftDistance + 1 == k)
                 list.add(root);
             int numSteps = k - leftDistance - 2;
             traverseDown(root.right, numSteps, list);
             return leftDistance + 1;
         }
         int rightDistance = traverse(root.right, target, k, list);
         if (rightDistance != -1) {
             if (rightDistance + 1 == k)
                 list.add(root);
             int numSteps = k - rightDistance - 2;
             traverseDown(root.left, numSteps, list);
             return rightDistance + 1;
         }
         return -1;
     }

     public static void traverseDown(TreeNode node, int k, ArrayList<TreeNode> list) {
         if (node == null || k < 0)
             return;
         if (k == 0) {
             list.add(node);
             return;
         }
         traverseDown(node.left, k - 1, list);
         traverseDown(node.right, k - 1, list);
     }
 }

