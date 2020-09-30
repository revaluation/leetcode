public class TreeNode {
    public final int val;
    public int size;
    public int repeats;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        size = 1;
        repeats = 1;
    }
}