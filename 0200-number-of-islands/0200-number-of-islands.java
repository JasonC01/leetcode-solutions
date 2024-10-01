class Solution {
    public int numIslands(char[][] grid) {
        int ans = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    ans++;
                    markVisited(grid, j, i, visited);
                }
            }
        }
        return ans;
    }

    public void markVisited(char[][] grid, int x, int y, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x1 = curr[0];
            int y1 = curr[1];
            if (x1 < 0 || y1 < 0 || x1 >= grid[0].length || y1 >= grid.length || visited[y1][x1] || grid[y1][x1] == '0') {
                continue;
            }
            visited[y1][x1] = true;
            q.add(new int[]{x1 + 1, y1});
            q.add(new int[]{x1 - 1, y1});
            q.add(new int[]{x1, y1 + 1});
            q.add(new int[]{x1, y1 - 1});
        }
    }

}