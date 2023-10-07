class Solution {
    int[][][] memo;
    int mod = (int) (1e9 + 7);
    public int numOfArrays(int n, int m, int k) {
        memo = new int[n + 1][k + 1][101];
        for (int[][] i : memo) {
            for (int[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return helper(n, m, k, 0);
    }

    public int helper(int n, int m, int remainingComparison, int largest) {
        if (remainingComparison < 0) {
            return 0;
        }
        if (n == 0) {
            return remainingComparison == 0 ? 1 : 0;
        }
        if (memo[n][remainingComparison][largest] != -1) {
            return memo[n][remainingComparison][largest];
        }
        int ans = 0;
        for (int i = 1; i <= m; i++) {
            int newRemainingComparison = i > largest ? remainingComparison - 1 : remainingComparison;
            ans = (ans + helper(n - 1, m, newRemainingComparison, Math.max(i, largest))) % mod;
        }
        return memo[n][remainingComparison][largest] = ans;
    }
}