class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i + 1, j});
                    q.add(new int[]{i - 1, j});
                    q.add(new int[]{i, j + 1});
                    q.add(new int[]{i, j - 1});
                }
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int level = 0;
        int levelSize = q.size();
        while (!q.isEmpty()) {
            if (levelSize == 0) {
                    level++;
                    levelSize = q.size();
                }
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            levelSize--;
            if (y < 0 || x < 0 || y >= grid.length || x >= grid[0].length || visited[y][x]) {
                continue;
            }
            if (grid[y][x] == 1) {
                visited[y][x] = true;
                grid[y][x] = 2;
                q.add(new int[]{y + 1, x});
                q.add(new int[]{y - 1, x});
                q.add(new int[]{y, x + 1});
                q.add(new int[]{y, x - 1});
                
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return level;
    }

}