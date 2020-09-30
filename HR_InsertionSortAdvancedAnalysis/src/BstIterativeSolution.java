// Time & Space - same as for BST Solution but not using the internal thread stack heavily
public class BstIterativeSolution implements ISolution {

    public long countNumOfSwaps(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;

        TreeNode bst = new TreeNode(arr[0]);
        long sum = 0;

        for (int i = 1; i < arr.length; i++) {
            int x = arr[i];

            sum += getCntGreaterThanVal(bst, x);
            addNode(bst, x);
        }

        return sum;
    }

    private void addNode(TreeNode node, int val) {
        assert node != null;

        while (true) {
            node.size++;

            if (val < node.val) {
                if (node.left != null) {
                    node = node.left;
                }
                else {
                    node.left = new TreeNode(val);
                    break;
                }
            }
            else if (val > node.val) {
                if (node.right != null) {
                    node = node.right;
                }
                else {
                    node.right = new TreeNode(val);
                    break;
                }
            }
            else {
                node.repeats++;
                break;
            }
        }
    }

    private int getCntGreaterThanVal(TreeNode node, int val) {
        assert node != null;

        int sum = 0;
        while (node != null) {
            if (val > node.val) {
                node = node.right;
            }
            else {
                sum += getSizeSafe(node.right);
                if (val == node.val)
                    break;

                sum += node.repeats;
                node = node.left;
            }
        }

        return sum;
    }

    private int getSizeSafe(TreeNode node) {
        return node != null ? node.size : 0;
    }
}
