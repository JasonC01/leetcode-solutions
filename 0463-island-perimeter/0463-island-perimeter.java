class Solution {
    public int islandPerimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    ans += checkSides(grid, j + 1, i);
                    ans += checkSides(grid, j, i + 1);
                    ans += checkSides(grid, j - 1, i);
                    ans += checkSides(grid, j, i - 1);
                }
                if (grid[i][j] == 1) {
                    if (i == 0) {
                        ans++;
                    }
                    if (i == grid.length - 1) {
                        ans++;
                    }
                    if (j == 0) {
                        ans++;
                    }
                    if (j == grid[0].length - 1) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    public int checkSides(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x > grid[0].length - 1 || y > grid.length - 1) {
            return 0;
        }
        return grid[y][x] == 1 ? 1 : 0;
    }
}