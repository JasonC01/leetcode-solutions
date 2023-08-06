class Solution {
    long[][] memo;
    int mod = (int) (1e9 + 7);
    public int numMusicPlaylists(int n, int goal, int k) {
        memo = new long[goal + 1][n + 1];
        memo[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= Math.min(i, n); j++) {
                memo[i][j] = memo[i - 1][j - 1] * (n - j + 1) % mod;
                if (j > k) {
                    memo[i][j] = (memo[i][j] + memo[i - 1][j] * (j - k)) % mod;
                }
            }
        }
        return (int) memo[goal][n];
    }
}