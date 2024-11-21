class Solution {
    int[][] moves = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    ans = Math.max(ans, dfs(grid, i, j, new boolean[grid.length][grid[0].length]));
                }
            }
        }
        return ans;
    }

    public int dfs(int[][] grid, int y, int x, boolean[][] visited) {
        if (y < 0 || x < 0 || y > grid.length - 1 || x > grid[0].length - 1 || visited[y][x] || grid[y][x] == 0) {
            return 0;
        }
        visited[y][x] = true;
        int ans = 0;
        for (int[] move : moves) {
            ans = Math.max(ans, dfs(grid, y + move[0], x + move[1], visited) + grid[y][x]);
        }
        visited[y][x] = false;
        return ans;
    }
}