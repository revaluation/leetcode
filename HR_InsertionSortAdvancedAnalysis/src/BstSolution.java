public class BstSolution implements ISolution {
    public long countNumOfSwaps(int[] arr) {
        TreeNode bst = null;
        long sum = 0;

        // for (int i = 0; i < arr.length; i++) {
        //     int x = arr[i];
        //     int greaterThan = getCntGreaterThanVal(bst, x);
        //     int numSwaps = countSwaps(arr, i);
        //     if (greaterThan != numSwaps) {
        //         System.out.println("for i = " + i + " figures differ: " + greaterThan + " vs " + numSwaps);
        //     }

        //     bst = addNode(bst, x);

        //     sum += numSwaps;
        // }

        for (int x : arr) {
            sum += getCntGreaterThanVal(bst, x);
            try {
                bst = addNode(bst, x);
            }
            catch (MyStackOverflowException ex) {
                var st = Thread.currentThread().getStackTrace();

                System.out.println("SO occured when adding " + x + " to the node " + ex.finalNode + ", depth is " + ex.depth);
                ex.so.printStackTrace();
                return -1;
            }
        }

        return sum;
    }

    // private int countSwaps(int[] arr, int i) {
    //     int x = arr[i];
    //     int numSwaps = 0;
    //     while (--i >= 0) {
    //         if (arr[i] > x) {
    //             numSwaps++;
    //         }
    //     }

    //     return numSwaps;
    // }


    private TreeNode addNode(TreeNode node, int val) throws MyStackOverflowException {
        if (node == null)
            return new TreeNode(val);

        try {
            if (val < node.val) {
                node.left = addNode(node.left, val);
            }
            else if (val > node.val) {
                node.right = addNode(node.right, val);
            }
            else { // val == node.val
                node.repeats++; // NB! Really important not to miss it and deal with repeated numbers
            }

            node.size++;
        }
        catch (StackOverflowError ex) {
            var myException = new MyStackOverflowException();
            myException.finalNode = node.val;
            myException.so = ex;
            throw myException;
        }
        return node;
    }

    public class MyStackOverflowException extends Throwable {
        public int finalNode;
        public int depth;
        public StackOverflowError so;
    }

    private long getCntGreaterThanVal(TreeNode node, int val) {
        if (node == null)
            return 0;

        if (val > node.val)
            return getCntGreaterThanVal(node.right, val);

        long sum = 0;
        if (val <= node.val) {
            sum = node.right != null ? node.right.size : 0;
        }

        if (val < node.val) {
            sum += node.repeats + getCntGreaterThanVal(node.left, val);
        }

        return sum;
    }
}
