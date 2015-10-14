package TreesGraphs;

//@formatter:off
 /**
 * Two nodes of a BST are swapped, correct the BST
 *
 *      10
 *     /  \
 *    7    9
 *   /\   / \
 *  3 13 11 16
 *
 */
//@formatter:on

 public class BSTSwapNodes {
     public static void main(String[] args) {
         TreeNode root = TreeUtils.createBST(3, 7, 9, 10, 11, 13, 16);
         System.out.println("Initial BST: " + BTtoLinkedList.generateLists(root));
         TreeNode node1 = TreeUtils.findBST(root, 9);
         TreeNode node2 = TreeUtils.findBST(root, 13);
         swapNodes(node1, node2);
         System.out.println("Swapped BST: " + BTtoLinkedList.generateLists(root));
         correctBST(root);
         System.out.println("Corrected BST: " + BTtoLinkedList.generateLists(root));
     }

     static TreeNode node1, node2, prev;

     public static void correctBST(TreeNode root) {
         inorder(root);
         swapNodes(node1, node2);
     }

     private static void inorder(TreeNode node) {
         if (node == null)
             return;
         inorder(node.left);
         if (prev != null) {
             if (node.data <= prev.data) {
                 if (node1 == null)
                     node1 = prev;
                 node2 = node;
             }
         }
         prev = node;
         inorder(node.right);
     }

     public static void swapNodes(TreeNode node1, TreeNode node2) {
         int temp = node1.data;
         node1.data = node2.data;
         node2.data = temp;
     }
 }

