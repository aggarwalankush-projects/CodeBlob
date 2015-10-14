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

    public void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    public void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }
}
