class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] arr : memo) Arrays.fill(arr, -1);
        return helper(text1, text2, 0, 0);
    }

    public int helper(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int res = 0;
        if (text1.charAt(i) == text2.charAt(j)) {
            res = 1 + helper(text1, text2, i + 1, j + 1);
        } else {
            res = Math.max(helper(text1, text2, i + 1, j), helper(text1, text2, i, j + 1));
        }
        memo[i][j] = res;
        return res;
    }
}