class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        pq.add(new int[]{0, 0, 0, 1});
        boolean[][] visited = new boolean[n][m];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            int cost = curr[3];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || visited[y][x]) continue;
            visited[y][x] = true;
            if (y == n - 1 && x == m - 1) {
                return time;
            }
            for (int i = -1; i <= 1; i++) {
                if (i != 0) {
                    if (x + i < m && x + i >= 0) pq.add(new int[]{x + i, y, Math.max(time, moveTime[y][x + i]) + cost, Math.max(1, (cost + 1) % 3)});
                    if (y + i < n && y + i >= 0) pq.add(new int[]{x, y + i, Math.max(time, moveTime[y + i][x]) + cost, Math.max(1, (cost + 1) % 3)});
                }
            }
        }
        return 0;
    }
}