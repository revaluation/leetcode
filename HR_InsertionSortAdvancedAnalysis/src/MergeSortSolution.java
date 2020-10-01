public class MergeSortSolution implements ISolution {
    @Override
    public long countNumOfSwaps(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return 0;

        return mergeSortAndCountSwaps(arr, 0, n - 1, new int[n]);
    }

    private long mergeSortAndCountSwaps(int[] arr, int l, int r, int[] aux) {
        if (l == r)
            return 0;

        int mid = l + (r - l) / 2;
        long swaps = mergeSortAndCountSwaps(arr, l, mid, aux);
        swaps += mergeSortAndCountSwaps(arr, mid + 1, r, aux);

        for (int i = l, j = mid + 1, k = l; k <= r; k++) {
            if (i > mid) {
                aux[k] = arr[j++];
            }
            else if (j > r) {
                aux[k] = arr[i++];
            }
            else if (arr[i] <= arr[j]) {
                aux[k] = arr[i++];
            }
            else { // if arr[i] > arr[j] - we need to count a swap
                aux[k] = arr[j++];
                swaps += mid + 1 - i;
            }
        }

        System.arraycopy(aux, l, arr, l, r - l + 1);

        return swaps;
    }
}
