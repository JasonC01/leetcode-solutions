class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = bSearchLow(nums, lower - nums[i]);
            int high = bSearchHigh(nums, upper - nums[i]);
            if (low == -1 || high == -1) {
                continue;
            }
            ans += (i >= low && i <= high) ? (high - low) : (high - low + 1);
        }
        return ans / 2;
    }

    public int bSearchLow(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low] >= target ? low : -1;
    }

    public int bSearchHigh(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        return nums[low] <= target ? low : -1;
    }
}