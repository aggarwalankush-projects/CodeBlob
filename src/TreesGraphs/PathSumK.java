package TreesGraphs;

//@formatter:off
import java.util.ArrayList; /**
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

public class PathSumK {
    public static void main(String[] args) {
        TreeNode root = createTree();
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


    public static TreeNode createTree() {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(17);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(9);
        TreeNode node6 = new TreeNode(16);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;
        return root;
    }

}

