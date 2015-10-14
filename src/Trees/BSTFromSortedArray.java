package Trees;

/**
 * Given a sorted (increasing order) array with unique integer elements,
 * Generate a binary search tree with minimal height.
 */
public class BSTFromSortedArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Tree generated with root: " + arrayToBST(array));
    }

    public static TreeNode arrayToBST(int[] array) {
        return arrayToBST(array, 0, array.length - 1);
    }

    private static TreeNode arrayToBST(int[] array, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(array[mid]);
        root.left = arrayToBST(array, low, mid - 1);
        root.right = arrayToBST(array, mid + 1, high);
        return root;
    }

}

