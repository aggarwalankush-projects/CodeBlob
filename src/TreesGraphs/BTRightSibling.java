package TreesGraphs;

//@formatter:off
 /**
 * Given a COMPLETE Binary tree, print right sibling of each node.
 *
 *       10 -> null
 *     /   \
 *    17 -> 13 -> null
 *   /  \     \
 *  3 -> 9 -> 16 -> null
 *
 */
//@formatter:on

 public class BTRightSibling {
     public static void main(String[] args) {
         Integer[] array = {10, 17, 13, 3, 9, null, 16};
         TreeNode root = TreeUtils.createBinaryTree(array);
         connectSibling(root);
         for (Integer elem : array) {
             if (elem == null) continue;
             TreeNode node = TreeUtils.findBinaryTree(root, elem);
             System.out.println("Right Sibling of " + node + ": " + node.siblingRight);
         }
     }

     public static void connectSibling(TreeNode root) {
         if (root == null)
             return;
         root.siblingRight = null;
         connectSiblingRecur(root);
     }

     private static void connectSiblingRecur(TreeNode node) {
         if (node == null)
             return;
         if (node.left != null)
             node.left.siblingRight = node.right;
         if (node.right != null)
             node.right.siblingRight =
                     node.siblingRight != null
                             ? (node.siblingRight.left != null ? node.siblingRight.left : node.siblingRight.right)
                             : null;
         connectSiblingRecur(node.left);
         connectSiblingRecur(node.right);
     }

 }

