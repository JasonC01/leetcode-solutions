class Solution {
    int mod = (int) (1e9 + 7);
    public int numTilings(int n) {
        int[] dp = new int[1001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (dp[i] + dp[i - 1]) % mod;
            dp[i] = (dp[i] + (dp[i - 2]) % mod) % mod;
            for (int j = -3; i + j >= 0; j--) {
                dp[i] = (dp[i] + (2 * dp[i + j]) % mod) % mod;
            }
        }
        return dp[n];
    }

}