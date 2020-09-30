import java.util.Arrays;

// Time Complexity O(N*logN + MAX_VALUE^logN), Space Complexity O(logN + MAX_VALUE)
public class DivideAndConquerSolution implements ISolution {
    private int size = 0;
    private long swaps;

    @Override
    public long countNumOfSwaps(int[] arr) {
        int n = arr.length;
        if (n == 0)
            return 0;

        size = findMax(arr) + 1;

        swaps = 0;
        countSwaps(arr, 0, n - 1);
        return swaps;
    }

    private int[] countSwaps(int[] arr, int l, int r) {
        if (l == r) {
            int[] res = new int[size];
            Arrays.fill(res, 0, arr[l], 1);
            return res;
        }

        int mid = l + (r - l) / 2;
        int[] left = countSwaps(arr, l, mid);
        int[] right = countSwaps(arr, mid + 1, r);

        for (int i = mid + 1; i <= r; i++) {
            swaps += left[arr[i]];
        }

        for (int i = 1; i < size; i++) {
            left[i] += right[i];
        }

        return left;
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int x : arr) {
            max = Math.max(max, x);
        }

        return max;
    }
}
