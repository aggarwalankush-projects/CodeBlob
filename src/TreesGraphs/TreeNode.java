package TreesGraphs;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
