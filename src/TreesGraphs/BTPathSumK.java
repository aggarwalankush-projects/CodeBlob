package TreesGraphs;

import java.util.ArrayList;
//@formatter:off
 /**
 * Given a binary tree, print all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf.
 *
 *       10
 *     /   \
 *    17    1
 *   / \     \
 *  3   9    16
 *
 */
//@formatter:on

 public class BTPathSumK {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBinaryTree(10, 17, 1, 3, 9, null, 16);
         System.out.println("All paths with Sum = 17 are " + findPaths(root, 17));
     }

     /**
      * Time Complexity: O(N*log(N))
      * Space Complexity: O(log(N))
      */
     public static ArrayList<ArrayList<Integer>> findPaths(TreeNode root, int k) {
         ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
         int depth = findDepth(root);
         int path[] = new int[depth];
         findPaths(root, k, path, 0, paths);
         return paths;
     }

     private static void findPaths(TreeNode node, int k, int[] path, int level, ArrayList<ArrayList<Integer>> paths) {
         if (node == null)
             return;
         path[level] = node.data;

         int sum = 0;
         for (int i = level; i >= 0; i--) {
             sum += path[i];
             if (sum == k)
                 addPath(paths, path, i, level);
         }
         findPaths(node.left, k, path, level + 1, paths);
         findPaths(node.right, k, path, level + 1, paths);
     }

     private static void addPath(ArrayList<ArrayList<Integer>> paths, int[] path, int start, int end) {
         ArrayList<Integer> list = new ArrayList<>();
         for (int i = start; i <= end; i++)
             list.add(path[i]);
         paths.add(list);
     }

     private static int findDepth(TreeNode node) {
         if (node == null)
             return 0;
         return 1 + Math.max(findDepth(node.left), findDepth(node.right));
     }
 }

