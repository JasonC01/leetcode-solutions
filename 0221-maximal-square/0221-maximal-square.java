class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[n - 1][i] = matrix[n - 1][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[n - 1][i]);
        }
        for (int i = 0; i < n; i++) {
            dp[i][m - 1] = matrix[i][m - 1] == '1' ? 1 : 0;
            max = Math.max(max, dp[i][m - 1]);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                if (matrix[i][j] == '1') dp[i][j] = Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1])) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max * max;
    }
}