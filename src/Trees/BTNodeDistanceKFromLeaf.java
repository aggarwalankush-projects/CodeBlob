package Trees;

import java.util.LinkedHashSet;
//@formatter:off
 /**
 * Given a binary tree, find all nodes at distance K from leaf.
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

 public class BTNodeDistanceKFromLeaf {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
         for (int i = 0; i < 3; i++)
             System.out.println("Nodes at distance K = " + i + " from leaf are " + findNodes(root, i));
     }

     public static LinkedHashSet<Integer> findNodes(TreeNode root, int k) {
         LinkedHashSet<Integer> nodes = new LinkedHashSet<>();
         int depth = findDepth(root);
         int path[] = new int[depth];
         findNodes(root, k, path, 0, nodes);
         return nodes;
     }

     private static void findNodes(TreeNode node, int k, int[] path, int level, LinkedHashSet<Integer> nodes) {
         if (node == null)
             return;
         path[level] = node.data;
         if (node.left == null && node.right == null && (level - k) >= 0) {
             nodes.add(path[level - k]);
             return;
         }

         findNodes(node.left, k, path, level + 1, nodes);
         findNodes(node.right, k, path, level + 1, nodes);
     }

     private static int findDepth(TreeNode node) {
         if (node == null)
             return 0;
         return 1 + Math.max(findDepth(node.left), findDepth(node.right));
     }
 }

