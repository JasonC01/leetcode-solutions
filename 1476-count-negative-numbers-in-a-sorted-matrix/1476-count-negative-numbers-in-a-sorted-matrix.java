class Solution {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        int start = grid[0].length - 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = start; j >= 0; j--) {
                if (grid[i][j] < 0) {
                    start--;
                    ans += grid.length - i;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}