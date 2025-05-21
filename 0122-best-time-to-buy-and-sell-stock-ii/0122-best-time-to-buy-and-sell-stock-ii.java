class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[prices.length - 1] = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < prices.length; j++) {
                dp[i] = Math.max(dp[i], dp[j]);
                dp[i] = Math.max(dp[i], prices[j] - prices[i] + dp[j]);
            }
        }
        return dp[0];
    }
}