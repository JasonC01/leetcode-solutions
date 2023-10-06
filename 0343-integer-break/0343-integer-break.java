class Solution {
    int[] memo;
    public int integerBreak(int n) {
        memo = new int[n + 1];
        return helper(n, 1, 0);
    }

    
    public int helper(int n, int product, int count) {
        if (n == 0) {
            return count > 1 ? product : Integer.MIN_VALUE;
        }
        if (memo[n] != 0) {
            return product * memo[n];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(helper(n - i, product * i, count + 1), ans);
        }
        memo[n] = ans / product;
        return ans;
    }
}