class Solution {
    int ans = 0;
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            if (!adjList.containsKey(from)) adjList.put(from, new ArrayList<>());
            if (!adjList.containsKey(to)) adjList.put(to, new ArrayList<>());
            adjList.get(from).add(new int[]{to, weight});
            adjList.get(to).add(new int[]{from, weight});
        }
        dfs(values, adjList, new HashMap<>(), 0, 0, values[0], maxTime);
        return ans;
    }

    public void dfs(int[] values, HashMap<Integer, List<int[]>> adjList, HashMap<Integer, Integer> visited, int curr, int currTime, int currVal, int maxTime) {
        if (currTime > maxTime) return;
        if (curr == 0) {
            ans = Math.max(ans, currVal);
        }
        visited.merge(curr, 1, (a, b) -> a + 1);
        for (int[] adj : adjList.getOrDefault(curr, new ArrayList<>())) {
            int nextPos = adj[0];
            int time = adj[1];
            dfs(values, adjList, visited, nextPos, currTime + time,
                    currVal + (visited.getOrDefault(nextPos, 0) > 0 ? 0 : values[nextPos]), maxTime);
        }
        visited.merge(curr, 0, (a, b) -> a - 1);
    }
}