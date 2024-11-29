class Solution {
    int[][] moves = new int[][]{new int[]{1, 0}, new int[]{-1, 0}, new int[]{0, 1}, new int[]{0, -1}};
    public int minimumTime(int[][] grid) {
        int[][] dist = new int[grid.length][grid[0].length];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        pq.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            visited[curr[0]][curr[1]] = true;
//            dist[curr[0]][curr[1]] = curr[2];
            if (curr[0] != grid.length - 1 || curr[1] != grid[0].length - 1) {
                for (int[] move : moves) {
                    int nY = curr[0] + move[0];
                    int nX = curr[1] + move[1];
                    if (nX < 0 || nY < 0 || nY > grid.length - 1 || nX > grid[0].length - 1 || visited[nY][nX] || dist[nY][nX] <= curr[2] + 1) {
                        continue;
                    }
                    if (grid[nY][nX] <= curr[2] + 1) {
                        dist[nY][nX] = curr[2] + 1;
                        pq.add(new int[]{nY, nX, curr[2] + 1});
                    } else {
                        if (curr[0] != 0 || curr[1] != 0) {
                            int diff = grid[nY][nX] - curr[2];
                            if (diff % 2 == 0) {
                                dist[nY][nX] = grid[nY][nX] + 1;
                                pq.add(new int[]{nY, nX, grid[nY][nX] + 1});
                            } else {
                                dist[nY][nX] = grid[nY][nX];
                                pq.add(new int[]{nY, nX, grid[nY][nX]});
                            }
                        } else {
                            boolean possible = false;
                            for (int[] m : moves) {
                                int a = curr[0] + m[0];
                                int b = curr[1] + m[1];
                                if (a < 0 || b < 0 || b > grid.length - 1 || a > grid[0].length - 1) {
                                    continue;
                                }
                                if (grid[a][b] <= curr[2] + 1) {
                                    possible = true;
                                }
                            }
                            if (possible) {
                                int diff = grid[nY][nX] - curr[2];
                                if (diff % 2 == 0) {
                                    dist[nY][nX] = grid[nY][nX] + 1;
                                    pq.add(new int[]{nY, nX, grid[nY][nX] + 1});
                                } else {
                                    dist[nY][nX] = grid[nY][nX];
                                    pq.add(new int[]{nY, nX, grid[nY][nX]});
                                }
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
        return dist[grid.length - 1][grid[0].length - 1] == Integer.MAX_VALUE ? -1 : dist[grid.length - 1][grid[0].length - 1];
    }
}