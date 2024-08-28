class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (visited[i][j] || grid2[i][j] == 0) {
                    continue;
                }
                int[] coord = new int[]{i, j};
                queue.add(coord);
                boolean isSubGrid = true;
                while (!queue.isEmpty()) {
                    int[] curr = queue.poll();
                    int y = curr[0];
                    int x = curr[1];
                    if (y < 0 || x < 0 || y > grid1.length - 1 || x > grid1[0].length - 1 || visited[y][x] || grid2[y][x] == 0) {
                        continue;
                    }
                    visited[y][x] = true;
                    if (grid1[y][x] == 0) {
                        isSubGrid = false;
                    }
                    queue.add(new int[]{y + 1, x});
                    queue.add(new int[]{y - 1, x});
                    queue.add(new int[]{y, x + 1});
                    queue.add(new int[]{y, x - 1});
                }
                if (isSubGrid) {
                    res++;
                }
            }
        }
        return res;
    }
}