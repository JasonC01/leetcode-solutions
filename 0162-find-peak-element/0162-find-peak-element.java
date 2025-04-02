class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int low, int high) {
        if (high <= low) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] > (mid - 1 < 0 ? Integer.MIN_VALUE : nums[mid - 1]) && nums[mid] > (mid + 1 > nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1])) {
            return mid;
        }
        int ans = helper(nums, low, mid);
        ans = Math.max(ans, helper(nums, mid + 1, high));
        return ans;
    }
}