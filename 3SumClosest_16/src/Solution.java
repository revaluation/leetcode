import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null)
            throw new IllegalArgumentException("Parameter cannot be null");
        if (nums.length < 3)
            throw new IllegalArgumentException("Input array should be longer than 2");

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        return threeSumClosestSorted(copy, target);
    }

    private int threeSumClosestSorted(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                int cmp = Integer.compare(sum, target);
                if(cmp == 0)
                    return target;

                closest = Math.abs(sum - target) < Math.abs(closest - target) ? sum : closest;
                if(cmp < 0)
                    lo++;
                else
                    hi--;
            }
        }

        return closest;
    }
}
