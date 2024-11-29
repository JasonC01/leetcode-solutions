class Solution {
    int[][] moves = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
    public int minimumObstacles(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] curr = q.removeFirst();
            if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1) {
                continue;
            }
            for (int[] move : moves) {
                int nY = curr[0] + move[0];
                int nX = curr[1] + move[1];
                int w = grid[curr[0]][curr[1]];
                if (nX < 0 || nY < 0 || nY > grid.length - 1 || nX > grid[0].length - 1 || dist[nY][nX] <= dist[curr[0]][curr[1]] + w) {
                    continue;
                }
                dist[nY][nX] = dist[curr[0]][curr[1]] + w;
                if (w == 1) {
                    q.addLast(new int[]{nY, nX});
                } else {
                    q.addFirst(new int[]{nY, nX});
                }
            }
        }
        return dist[grid.length - 1][grid[0].length - 1];
    }
}
