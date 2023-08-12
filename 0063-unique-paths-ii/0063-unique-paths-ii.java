class Solution {
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        memo = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
        return dfs(obstacleGrid, 0, 0);
    }

    public int dfs(int[][] grid, int x, int y) {
        if (x > grid[0].length - 1 || y > grid.length - 1 || grid[y][x] == 1) {
            return 0;
        }
        if (x == grid[0].length - 1 && y == grid.length - 1) {
            return 1;
        }
        if (memo[y][x] != 0) {
            return memo[y][x];
        }
        return memo[y][x] = dfs(grid, x + 1, y) + dfs(grid, x, y + 1);
    }
}