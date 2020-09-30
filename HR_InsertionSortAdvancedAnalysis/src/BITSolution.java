// Time Complexity: O(N*logN), Space Complexity: O(N)
public class BITSolution implements ISolution {

    @Override
    public long countNumOfSwaps(int[] arr) {
        int max = findMax(arr);
        BinaryIndexedTree bit = new BinaryIndexedTree(max);

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];

            sum += i - bit.sum(x);
            bit.add(x, 1);
        }

        return sum;
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int x : arr) {
            max = Math.max(max, x);
        }

        return max;
    }
}
