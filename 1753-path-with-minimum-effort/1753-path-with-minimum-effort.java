class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] distances = new int[heights.length][heights[0].length];
        boolean[][] visited = new boolean[heights.length][heights[0].length];
        for (int[] i : distances) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        distances[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[]{0, 0, 0});
        int[][] adj = new int[][]{new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[1];
            int y = curr[0];
            int effort = curr[2];
            if (effort > distances[y][x]) {
                continue;
            }
            if (y == heights.length - 1 && x == heights[0].length - 1) {
                return effort;
            }
            for (int[] next : adj) {
                int nextX = x + next[1];
                int nextY = y + next[0];
                if (nextX < 0 || nextY < 0 || nextX > heights[0].length - 1 || nextY > heights.length - 1) {
                    continue;
                }
                int newEffort = Math.max(effort, Math.abs(heights[y][x] - heights[nextY][nextX]));
                if (newEffort < distances[nextY][nextX]) {
                    distances[nextY][nextX] = newEffort;
                    pq.add(new int[]{nextY, nextX, newEffort});
                }
            }
        }
        return -1;
    }
}