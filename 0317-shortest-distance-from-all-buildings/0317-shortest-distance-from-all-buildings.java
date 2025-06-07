class Solution {
    public int shortestDistance(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int buildingCount = 0;
        Queue<int[]> q = new ArrayDeque<>();
        int[][] distances = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j, buildingCount, 0}); // yCoord, xCoord, buildingIdentifier, distance
                    buildingCount++;
                }
            }
        }
        boolean[][][] visited = new boolean[n][m][buildingCount];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int buildingIndex = curr[2];
            int dist = curr[3];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || visited[y][x][buildingIndex] || grid[y][x] == 2 || (grid[y][x] == 1 && dist > 0)) continue;
            visited[y][x][buildingIndex] = true;
            distances[y][x] += dist;
            q.add(new int[]{y + 1, x, buildingIndex, dist + 1});
            q.add(new int[]{y - 1, x, buildingIndex, dist + 1});
            q.add(new int[]{y, x + 1, buildingIndex, dist + 1});
            q.add(new int[]{y, x - 1, buildingIndex, dist + 1});
        }
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    boolean allVisited = true;
                    for (int k = 0; k < buildingCount; k++) {
                        if (!visited[i][j][k]) {
                            allVisited = false;
                            break;
                        }
                    }
                    if (allVisited && distances[i][j] < minDist) {
                        minDist = distances[i][j];
                    }
                }
            }
        }
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}