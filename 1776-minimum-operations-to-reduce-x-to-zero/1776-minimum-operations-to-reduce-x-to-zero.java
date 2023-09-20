class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (x > total) {
            return -1;
        }
        int target = total - x;
        int ans = Integer.MAX_VALUE;
        int currentSum = 0;
        int low = 0;
        int high = -1;
        while (low < nums.length) {
            if (currentSum == target) {
                ans = Math.min(ans, nums.length - (high - low + 1));
                currentSum -= nums[low++];
            }
            if (currentSum > target) {
                currentSum -= nums[low++];
            } else {
                high++;
                if (high > nums.length - 1) {
                    break;
                }
                currentSum += nums[high];

            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}