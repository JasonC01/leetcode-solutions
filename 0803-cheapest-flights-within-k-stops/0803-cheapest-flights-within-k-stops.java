class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distances = new int[n];
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            adjList.get(from).add(new int[]{to, cost});
        }
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;
        boolean updated = false;
        for (int iter = 0; iter <= k; iter++) {
            List<int[]> toBeUpdatd = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (distances[i] != Integer.MAX_VALUE) {
                    for (int[] dest : adjList.getOrDefault(i, new ArrayList<>())) {
                        int to = dest[0];
                        int cost = dest[1];
                        if (distances[to] > distances[i] + cost) {
                            updated = true;
                            toBeUpdatd.add(new int[]{to, distances[i] + cost});
//                            distances[to] = distances[i] + cost;
                        }
                    }
                }
            }
            for (int[] dest : toBeUpdatd) {
                distances[dest[0]] = Math.min(distances[dest[0]], dest[1]);
            }
            // if (!updated) break;
            updated = false;
        }
        System.out.println(Arrays.toString(distances));
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}