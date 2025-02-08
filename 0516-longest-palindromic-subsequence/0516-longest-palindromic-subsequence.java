class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
        memo = new int[s.length()][s.length()];
        return helper(s, 0, s.length() - 1);
    }

    public int helper(String s, int left, int right) {
        if (left >= right) {
            return left == right ? 1 : 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        int ans = 0;
        if (s.charAt(left) == s.charAt(right)) {
            ans = Math.max(ans, 2 + helper(s, left + 1, right - 1));
        } else {
            ans = Math.max(ans, helper(s, left + 1, right));
            ans = Math.max(ans, helper(s, left, right - 1));
        }
        return memo[left][right] = ans;
    }
}