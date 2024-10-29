class Solution {
    int[][] memo;
    public int maxMoves(int[][] grid) {
        memo = new int[grid.length][grid[0].length];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            ans = Math.max(ans, dfs(grid, i, 0, 0, 0));
        }
        return ans;
    }

    public int dfs(int[][] grid, int y, int x, int moves, int prev) {
        if (y < 0 || x < 0 || y > grid.length - 1 || x > grid[0].length - 1 || grid[y][x] <= prev) {
            return moves - 1;
        }
        if (memo[y][x] != -1) {
            return moves + memo[y][x];
        }
        int res = moves;
        int[][] next = new int[][]{new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1}};
        for (int[] n : next) {
            res = Math.max(res, dfs(grid, y + n[0], x + n[1], moves + 1, grid[y][x]));
        }
        memo[y][x] = res - moves;
        return res;
    }
}