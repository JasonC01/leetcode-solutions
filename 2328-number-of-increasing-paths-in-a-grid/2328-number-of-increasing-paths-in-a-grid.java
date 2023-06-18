class Solution {
    int mod = (int) (1e9 + 7);
    int[][] memo;
    public int countPaths(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (memo[i][j] != 0) {
                    ans = (ans + memo[i][j]) % mod;
                } else {
                    ans = (ans + dfs(grid, j, i, 0, new boolean[grid.length][grid[0].length])) % mod;
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int x, int y, int prev, boolean[][] visited) {
        if (x > grid[0].length - 1 || x < 0 || y > grid.length - 1 || y < 0 || grid[y][x] <= prev || visited[y][x]) {
            return 0;
        }
        if (memo[y][x] != 0) {
            return memo[y][x];
        }
        int curr = grid[y][x];
        visited[y][x] = true;
        int ans = dfs(grid, x + 1, y, curr, visited);
        ans = (ans + dfs(grid, x - 1, y, curr, visited)) % mod;
        ans = (ans + dfs(grid, x, y + 1, curr, visited)) % mod;
        ans = (ans + dfs(grid, x, y - 1, curr, visited)) % mod;
        visited[y][x] = false;
        memo[y][x] = 1 + ans;
        return memo[y][x] % mod;

    }
}