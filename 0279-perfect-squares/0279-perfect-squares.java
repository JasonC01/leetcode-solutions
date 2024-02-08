class Solution {
    int[] memo;
    public int numSquares(int n) {
        memo = new int[n + 1];
        return helper(n);
    }

    public int helper(int n) {
        if (n == 0) {
            return 0;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            ans = Math.min(ans, 1 + helper((int) (n - Math.pow(i, 2))));
        }
        return memo[n] = ans;
    }
}