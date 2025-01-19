class Solution {
    public int trapRainWater(int[][] heightMap) {
        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> heightMap[x[0]][x[1]]));
        int remCount = (heightMap.length - 2) * (heightMap[0].length - 2);
        int ans = 0;
        for (int i = 0; i < visited.length; i++) {
            visited[i][0] = true;
            visited[i][visited[0].length - 1] = true;
            pq.add(new int[]{i, 0});
            pq.add(new int[]{i, visited[0].length - 1});
        }
        for (int i = 0; i < visited[0].length; i++) {
            visited[0][i] = true;
            visited[visited.length - 1][i] = true;
            pq.add(new int[]{0, i});
            pq.add(new int[]{visited.length - 1, i});
        }
        while (remCount > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int y = curr[0];
            int x = curr[1];
            int currHeight = heightMap[y][x];
            if (!visited[y][x]) {
                remCount--;
            }
            visited[y][x] = true;
            if (y + 1 < heightMap.length && !visited[y + 1][x]) {
                ans += Math.max(0, currHeight - heightMap[y + 1][x]);
                heightMap[y + 1][x] = Math.max(heightMap[y + 1][x], currHeight);
                pq.add(new int[]{y + 1, x});
            }
            if (y - 1 >= 0 && !visited[y - 1][x]) {
                ans += Math.max(0, currHeight - heightMap[y - 1][x]);
                heightMap[y - 1][x] = Math.max(heightMap[y - 1][x], currHeight);
                pq.add(new int[]{y - 1, x});
            }
            if (x + 1 < heightMap[0].length && !visited[y][x + 1]) {
                ans += Math.max(0, currHeight - heightMap[y][x + 1]);
                heightMap[y][x + 1] = Math.max(heightMap[y][x + 1], currHeight);
                pq.add(new int[]{y, x + 1});
            }
            if (x - 1 >= 0 && !visited[y][x - 1]) {
                ans += Math.max(0, currHeight - heightMap[y][x - 1]);
                heightMap[y][x - 1] = Math.max(heightMap[y][x - 1], currHeight);
                pq.add(new int[]{y, x - 1});
            }
        }
        return ans;
    }
}