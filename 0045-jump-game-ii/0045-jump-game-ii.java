class Solution {
    public int jump(int[] nums) {
        int MAX_VAL = (int) (1e4 + 1);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, MAX_VAL);
        dp[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int jumps = nums[i];
            for (int j = 1; j <= jumps && i + j < nums.length; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + j]);
            }
        }
        return dp[0];
    }
}