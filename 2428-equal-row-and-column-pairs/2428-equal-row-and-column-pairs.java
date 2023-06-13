class Solution {
    public int equalPairs(int[][] grid) {
        int[][] cols = new int[grid[0].length][grid.length];
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                cols[i][j] = grid[j][i];
            }
        }
        for (int[] col : cols) {
            System.out.println(Arrays.toString(col));
        }
        int count = 0;
        for (int[] row : grid) {
            for (int[] col : cols) {
                if (Arrays.equals(row, col)) {
                    count++;
                }
            }
        }
        return count;
    }
}