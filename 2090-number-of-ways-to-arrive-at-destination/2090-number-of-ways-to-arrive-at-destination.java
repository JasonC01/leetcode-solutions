class Solution {
    int mod = (int) (1e9 + 7);
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int startNode = road[0], endNode = road[1], travelTime = road[2];
            graph.get(startNode).add(new int[] { endNode, travelTime });
            graph.get(endNode).add(new int[] { startNode, travelTime });
        }
        int[] pathCounts = new int[n];
        long[] minDists = new long[n];
        Arrays.fill(minDists, Long.MAX_VALUE);
        minDists[0] = 0;
        pathCounts[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(x -> x[0]));
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int) curr[1];
            if (currTime > minDists[currNode]) {
                continue;
            }
            for (int[] adj : graph.get(currNode)) {
                int adjNode = adj[0];
                long newWeight = adj[1] + minDists[currNode];
                if (newWeight < minDists[adjNode]) {
                    pathCounts[adjNode] = pathCounts[currNode];
                    minDists[adjNode] = newWeight;
                    pq.add(new long[]{newWeight, adjNode});
                } else if (newWeight == minDists[adjNode]) {
                    pathCounts[adjNode] = (pathCounts[adjNode] + pathCounts[currNode]) % mod;
                }
            }
        }
        return (int) pathCounts[n - 1];
    }
}