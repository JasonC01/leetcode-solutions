class Solution {
    public int equalPairs(int[][] grid) {
        HashSet<int[]> rows = new HashSet<>(Arrays.asList(grid));
        int ans = 0;
        for (int i = 0; i < grid[0].length; i++) {
            int[] col = new int[grid[0].length];
            for (int j = 0; j < grid.length; j++) {
                col[j] = grid[j][i];
            }
            for (int[] row : rows) {
                if (Arrays.equals(row, col)) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}