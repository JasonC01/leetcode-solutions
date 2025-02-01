class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length; 
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = matrix[m - 1][i] == '1' ? 1 : 0;
            ans = Math.max(ans, dp[m - 1][i]);
        }
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = matrix[i][n - 1] == '1' ? 1 : 0;
            ans = Math.max(ans, dp[i][n - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i + 1][j + 1], dp[i + 1][j]), dp[i][j + 1]);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans * ans;
    }
}