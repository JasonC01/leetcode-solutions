class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        HashMap<Integer, List<int[]>> adjList = new HashMap<>();
        PriorityQueue<int[]> edgesQueue = new PriorityQueue<>(Comparator.comparing(x -> x[2]));
        int[] outDegree = new int[n];
        HashSet<Integer> visited = new HashSet<>();
        int maxEdge = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            int from = edge[1];
            adjList.computeIfAbsent(from, x -> new ArrayList<>());
            adjList.get(from).add(edge);
        }
        edgesQueue.addAll(adjList.getOrDefault(0, new ArrayList<>()));
        while (!edgesQueue.isEmpty()) {
            int[] currEdge = edgesQueue.poll();
            int from = currEdge[1];
            int to = currEdge[0];
            int weight = currEdge[2];
            if (visited.contains(to)) continue;
            visited.add(from);
            visited.add(to);
            outDegree[to]++;
            maxEdge = Math.max(maxEdge, weight);
            edgesQueue.addAll(adjList.getOrDefault(to, new ArrayList<>()));
        }
        return visited.size() == n ? maxEdge : -1;
    }
}