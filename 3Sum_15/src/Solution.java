import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null)
            throw new IllegalArgumentException("Parameter cannot be null");

        if(nums.length < 3)
            return new LinkedList<>();

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        return threeSumInOrderedArr(copy);
    }

    private List<List<Integer>> threeSumInOrderedArr(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i - 1] == nums[i])
                continue;
            List<List<Integer>> twoSums = twoSumInOrderedArr(nums, i + 1, -nums[i]);
            for(List<Integer> twoSum : twoSums) {
                List<Integer> threeSum = Arrays.asList(nums[i], twoSum.get(0), twoSum.get(1));
                res.add(threeSum);
            }
        }

        return res;
    }

    private List<List<Integer>> twoSumInOrderedArr(int[] nums, int start, int target) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        int lo = start, hi = nums.length - 1;

        while(lo < hi) {
            int sum = nums[lo] + nums[hi];
            int cmp = Integer.compare(sum, target);
            if(cmp == 0) {
                res.add(Arrays.asList(nums[lo], nums[hi]));
                while(lo < hi && nums[lo] == nums[lo + 1])
                    lo++;
                lo++;
            }
            else if(cmp < 0)
                lo++;
            else
                hi--;
        }

        return res;
    }
}
