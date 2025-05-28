class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int start = grid.get(0).get(0);
        int end = grid.get(n - 1).get(m - 1);
        if (start == 1 || end == 1) return 0;
        int[][] newGrid = new int[n][m];
        for (int[] i : newGrid) Arrays.fill(i, Integer.MAX_VALUE);
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int dist = curr[2];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || dist >= newGrid[y][x]) continue;
            newGrid[y][x] = dist;
            q.add(new int[]{y + 1, x, dist + 1});
            q.add(new int[]{y - 1, x, dist + 1});
            q.add(new int[]{y, x + 1, dist + 1});
            q.add(new int[]{y, x - 1, dist + 1});
        }
        int low = 0;
        int high = Math.max(newGrid[0][0], newGrid[n - 1][m - 1]);
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (dfs(newGrid, 0, 0, new boolean[n][m], mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean dfs(int[][] grid, int y, int x, boolean[][] visited, int limit) {
        int n = grid.length;
        int m = grid[0].length;
        if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || visited[y][x] || grid[y][x] < limit) return false;
        if (y == n - 1 && x == m - 1) return true;
        boolean res = false;
        visited[y][x] = true;
        res |= dfs(grid, y + 1, x, visited, limit);
        res |= dfs(grid, y - 1, x, visited, limit);
        res |= dfs(grid, y, x + 1, visited, limit);
        res |= dfs(grid, y, x - 1, visited, limit);
        return res;
    }
}