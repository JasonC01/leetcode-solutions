class Solution {
    public int minCostConnectPoints(int[][] points) {
        int[][] adjList = new int[points.length][points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                adjList[i][j] = manhattanDistance(points[i], points[j]);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> adjList[x[0]][x[1]]));
        HashSet<Integer> added = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            pq.add(new int[]{0, i});
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (added.contains(curr[0]) && added.contains(curr[1])) {
                continue;
            }
            for (int i = 0; i < points.length; i++) {
                if (!added.contains(i)) {
                    pq.add(new int[]{curr[1], i});
                }
            }
            added.add(curr[0]);
            added.add(curr[1]);
            ans += adjList[curr[0]][curr[1]];
        }
        return ans;
    }


    public int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}