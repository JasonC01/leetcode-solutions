class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            int sum = 0;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
            rows[i] = sum;
        }
        for (int i = 0; i < grid[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    sum++;
                }
            }
            cols[i] = sum;
        }
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans[i][j] = 2 * rows[i] + 2 * cols[j] - grid.length - grid[0].length;
            }
        }
        return ans;
    }
}