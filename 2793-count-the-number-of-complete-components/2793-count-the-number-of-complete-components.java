class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            if (!adjList.containsKey(to)) {
                adjList.put(to, new ArrayList<>());
            }
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                Queue<Integer> q = new ArrayDeque<>();
                q.add(i);
                int edgeCount = 0;
                int nodesCount = 0;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    if (!visited.contains(curr)) {
                        nodesCount++;
                        visited.add(curr);
                        for (int adj : adjList.getOrDefault(curr, new ArrayList<>())) {
                            if (!visited.contains(adj)) {
                                edgeCount++;
                                q.add(adj);
                            }
                        }
                    }
                }
                if ((nodesCount * (nodesCount - 1) / 2) == edgeCount) ans++;
            }
        }
        return ans;
    }
}