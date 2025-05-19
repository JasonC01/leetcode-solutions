class Solution {
    public int lengthOfLIS(int[] nums) {
        int ans = 0;
        int[] dp = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int max = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) max = Math.max(max, dp[j]);
            }
            dp[i] = max + 1;
        }
        for (int i : dp) ans = Math.max(ans, i);
        return ans;
    }

}