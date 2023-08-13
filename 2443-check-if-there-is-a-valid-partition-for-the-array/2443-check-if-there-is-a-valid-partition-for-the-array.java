class Solution {
    public boolean validPartition(int[] nums) {
        boolean[] dp = new boolean[nums.length + 1];
        dp[nums.length] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[i] = (nums[i] == nums[i + 1] && dp[i + 2]) ||
                    (nums[i] == nums[i + 1] && nums[i] == nums[Math.min(i + 2, nums.length - 1)] && dp[Math.min(i + 3, nums.length)]) ||
                    (nums[i] == nums[i + 1] - 1 && nums[i] == nums[Math.min(i + 2, nums.length - 1)] - 2 && dp[Math.min(i + 3, nums.length)]);

        }
        return dp[0];
    }
}