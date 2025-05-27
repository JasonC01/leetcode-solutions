class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(matrix[b[0]][b[1]], matrix[a[0]][a[1]]));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(new int[]{i, j});
            }
        }
        int ans = 0;
        for (int[] arr : dp) Arrays.fill(arr, 1);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int y = curr[0];
            int x = curr[1];
            if (y + 1 < n && matrix[y + 1][x] > matrix[y][x]) dp[y][x] = Math.max(dp[y][x], 1 + dp[y + 1][x]);
            if (y - 1 >= 0 && matrix[y - 1][x] > matrix[y][x]) dp[y][x] = Math.max(dp[y][x], 1 + dp[y - 1][x]);
            if (x + 1 < m && matrix[y][x + 1] > matrix[y][x]) dp[y][x] = Math.max(dp[y][x], 1 + dp[y][x + 1]);
            if (x - 1 >= 0 && matrix[y][x - 1] > matrix[y][x]) dp[y][x] = Math.max(dp[y][x], 1 + dp[y][x - 1]);
            ans = Math.max(ans, dp[y][x]);
        }
        // System.out.println(Arrays.deepToString(dp));
        return ans;
    }
}