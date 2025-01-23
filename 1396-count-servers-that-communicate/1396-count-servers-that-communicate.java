class Solution {
    public int countServers(int[][] grid) {
        HashMap<Integer, Integer> rowCounter = new HashMap<>();
        HashMap<Integer, Integer> colCounter = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    rowCounter.merge(i, 1, (a, b) -> a + 1);
                    colCounter.merge(j, 1, (a, b) -> a + 1);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (rowCounter.get(i) > 1 || colCounter.get(j) > 1)) {
                   ans++;
                }
            }
        }
        return ans;
    }
}