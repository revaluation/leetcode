public class BinaryIndexedTree {
    private long[] ranges;
    public BinaryIndexedTree(int size) {
        ranges = new long[size + 1];
    }

    public long sum(int x) {
        long sum = 0;
        while (x > 0) {
            sum += ranges[x];
            x = removeLeastSignificantBit(x);
        }

        return sum;
    }

    public void add(int x, int val) {
        while (x < ranges.length) {
            ranges[x] += val;

            x = doubleLeastSignificantBit(x);
            if (x == 0) break;
        }
    }

    public int removeLeastSignificantBit(int x) {
        return x - (x & (-x));
    }

    public int doubleLeastSignificantBit(int x) {
        return x + (x & (-x));
    }
}
