class Solution {
    int mod = (int) (1e9 + 7);

    int[][] memo;
    public int countVowelPermutation(int n) {
        memo = new int[n + 1][22];
        return helper(n, '`');
    }

    public int helper(int n, char prev) {
        if (n == 0) {
            return 1;
        }
        if (memo[n][prev - 96] != 0) {
            return memo[n][prev - 96];
        }
        int ans = 0;
        if (prev == '`') {
            ans = (ans + helper(n - 1, 'a')) % mod;
            ans = (ans + helper(n - 1, 'e')) % mod;
            ans = (ans + helper(n - 1, 'i')) % mod;
            ans = (ans + helper(n - 1, 'o')) % mod;
            ans = (ans + helper(n - 1, 'u')) % mod;
        } else if (prev == 'a') {
            ans = (ans + helper(n - 1, 'e')) % mod;
        } else if (prev == 'e') {
            ans = (ans + helper(n - 1, 'a')) % mod;
            ans = (ans + helper(n - 1, 'i')) % mod;
        } else if (prev == 'i') {
            ans = (ans + helper(n - 1, 'a')) % mod;
            ans = (ans + helper(n - 1, 'e')) % mod;
            ans = (ans + helper(n - 1, 'o')) % mod;
            ans = (ans + helper(n - 1, 'u')) % mod;
        } else if (prev == 'o') {
            ans = (ans + helper(n - 1, 'i')) % mod;
            ans = (ans + helper(n - 1, 'u')) % mod;
        } else {
            ans = (ans + helper(n - 1, 'a')) % mod;
        }
        return memo[n][prev - 96] = ans;
    }

}