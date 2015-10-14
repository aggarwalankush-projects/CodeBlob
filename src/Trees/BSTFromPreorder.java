package Trees;

//@formatter:off
import java.util.Stack; /**
 * Given pre-order traversal of a binary search tree, construct the BST.
 *
 *      10
 *     /  \
 *    7   13
 *   / \  / \
 *  3  9 11 16
 *
 */
//@formatter:on

public class BSTFromPreorder {
    public static void main(String[] args) {
        int[] preorder = {10, 7, 3, 9, 13, 11, 16};
        TreeNode root = bstFromPreorder(preorder);
        System.out.println("BST created: " + BTtoLinkedList.generateLists(root));
    }

    /**
     * Time Complexity: O(N)
     */
    public static TreeNode bstFromPreorder(int[] preoder) {
        if (preoder == null || preoder.length < 1)
            return null;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preoder[0]);
        stack.push(root);
        for (int i = 1; i < preoder.length; i++) {
            TreeNode node = new TreeNode(preoder[i]);
            TreeNode prev = null;
            while (!stack.isEmpty() && node.data > stack.peek().data)
                prev = stack.pop();

            if (prev != null)
                prev.right = node;
            else
                stack.peek().left = node;

            stack.push(node);
        }
        return root;
    }
}

