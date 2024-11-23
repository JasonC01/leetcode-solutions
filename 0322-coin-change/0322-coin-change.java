class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i : coins) {
            if (i <= amount) {
                dp[i] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            if (dp[i] == 1) {
                continue;
            }
            for (int c : coins) {
                int prev = i - c < 0 ? Integer.MAX_VALUE : dp[i - c];
                if (prev != Integer.MAX_VALUE) dp[i] = Math.min(dp[i], prev + 1);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}