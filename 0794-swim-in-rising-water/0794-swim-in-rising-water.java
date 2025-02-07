class Solution {

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        for (int[] i : res) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        // res[0][0] = grid[0][0];
        // res[n - 1][m - 1] = grid[n - 1][m - 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0, grid[0][0]});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int currMin = curr[2];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1) {
                continue;
            }
            if (y == n - 1 && x == m - 1) {
                res[y][x] = Math.min(res[y][x], currMin);
                continue;
            }
            if (currMin < res[y][x]) {
                res[y][x] = currMin;
                int newMin = Math.max(currMin, grid[y][x]);
                q.add(new int[]{y + 1, x, newMin});
                q.add(new int[]{y - 1, x, newMin});
                q.add(new int[]{y, x + 1, newMin});
                q.add(new int[]{y, x - 1, newMin});
            }
        }
        // System.out.println(Arrays.deepToString(res));
        return Math.max(res[n - 1][m - 1], grid[n - 1][m - 1]);
    }
}