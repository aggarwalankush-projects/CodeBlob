package TreesGraphs;

import java.util.ArrayDeque;

public class TreeUtils {
    /**
     * @param array - sorted array of elements
     * @return root of BST
     */
    public static TreeNode createBST(int... array) {
        return arrayToBST(array, 0, array.length - 1);
    }

    private static TreeNode arrayToBST(int[] array, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.setLeftChild(arrayToBST(array, low, mid - 1));
        root.setRightChild(arrayToBST(array, mid + 1, high));
        return root;
    }

    /**
     * @param root - root of BST
     * @param data - data of node to be found
     * @return Node having required data
     */
    public static TreeNode findBST(TreeNode root, int data) {
        if (root == null)
            return null;
        if (root.data == data)
            return root;
        if (data < root.data)
            return root.left != null ? findBST(root.left, data) : null;
        else
            return root.right != null ? findBST(root.right, data) : null;
    }

    /**
     * @param array - array of elements, can have null values if left or right child is null of a non-leaf node
     * @return root of binary tree
     */
    public static TreeNode createBinaryTree(Integer... array) {
        if (array == null || array.length < 1)
            return null;
        TreeNode root = new TreeNode(array[0]);
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int i = 1;
        int len = array.length;
        while (i != len) {
            TreeNode node = queue.poll();
            node.setLeftChild(array[i] != null ? new TreeNode(array[i]) : null);
            i++;
            if (node.left != null)
                queue.add(node.left);
            if (i != len) {
                node.setRightChild(array[i] != null ? new TreeNode(array[i]) : null);
                i++;
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * @param root - root of binary tree
     * @param data - data of node to be found
     * @return Node having required data
     */
    public static TreeNode findBinaryTree(TreeNode root, int data) {
        if (root == null)
            return null;
        if (root.data == data)
            return root;
        TreeNode node = findBinaryTree(root.left, data);
        return node != null ? node : findBinaryTree(root.right, data);
    }
}


