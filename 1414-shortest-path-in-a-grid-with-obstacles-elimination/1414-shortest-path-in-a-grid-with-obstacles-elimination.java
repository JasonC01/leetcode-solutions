class Solution {
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited= new boolean[m][n][k + 1];
        int ans = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, k, 0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int breaks = curr[2];
            int steps = curr[3];
            if (y < 0 || x < 0 || y > m - 1 || x > n - 1 || breaks < 0) continue;
            if (y == m - 1 && x == n - 1) {
                ans = Math.min(ans, steps);
                continue;
            }
            if (!visited[y][x][breaks]) {
                visited[y][x][breaks] = true;
                if (y - 1 >= 0) q.add(new int[]{y - 1, x, breaks - grid[y - 1][x], steps + 1});
                if (x - 1 >= 0) q.add(new int[]{y, x - 1, breaks - grid[y][x - 1], steps + 1});
                if (y + 1 < m) q.add(new int[]{y + 1, x, breaks - grid[y + 1][x], steps + 1});
                if (x + 1 < n) q.add(new int[]{y, x + 1, breaks - grid[y][x + 1], steps + 1});
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}