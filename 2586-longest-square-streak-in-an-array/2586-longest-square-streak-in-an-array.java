class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int[] dp = new int[100001];
        for (int i = nums.length - 1; i >= 0; i--) {
            int curr = nums[i];
            dp[curr] = Math.max(1, Math.pow(curr, 2) < dp.length ? dp[(int) Math.pow(curr, 2)] + 1: 0);
            ans = Math.max(dp[curr], ans);
        }
        return ans == 1 ? -1 : ans;
    }
}