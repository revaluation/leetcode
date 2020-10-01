public class MergeSortIterativeSolution implements ISolution {
    @Override
    public long countNumOfSwaps(int[] arr) {
        int n = arr.length;
        if (n < 2)
            return 0;

        int[] aux = new int[n];
        long swaps = 0;

        for (int size = 1; size < n; size *= 2) {
            for (int start = 0; start < n; start += 2 * size) {
                int end = Math.min(start + 2 * size, n);

                for (int i = start, j = start + size, k = start; k < end; k++) {
                    if (i == start + size) {
                        aux[k] = arr[j++];
                    }
                    else if (j >= end) {
                        aux[k] = arr[i++];
                    }
                    else if (arr[i] <= arr[j]) {
                        aux[k] = arr[i++];
                    }
                    else { // if (arr[i] > arr[j] - we count swaps
                        aux[k] = arr[j++];
                        swaps += start + size - i;
                    }
                }
            }

            int[] tmp = arr;
            arr = aux;
            aux = tmp;
        }

        return swaps;
    }
}