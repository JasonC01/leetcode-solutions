class Graph {
        List<List<Integer>> adjList = new ArrayList<>();
        List<List<Integer>> edgeCosts = new ArrayList<>();

        public Graph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
                edgeCosts.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int cost = edge[2];
                adjList.get(from).add(to);
                edgeCosts.get(from).add(cost);
            }
        }

        public void addEdge(int[] edge) {
            int from = edge[0];
            int to = edge[1];
            int cost = edge[2];
            adjList.get(from).add(to);
            edgeCosts.get(from).add(cost);
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[1]));
            pq.add(new int[]{node1, 0});
            HashSet<Integer> visited = new HashSet<>();
            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int val = curr[0];
                int cost = curr[1];
                if (val == node2) {
                    return cost;
                }
                if (visited.contains(val)) {
                    continue;
                }
                visited.add(val);
                for (int i = 0; i < adjList.get(val).size(); i++) {
                    pq.add(new int[]{adjList.get(val).get(i), edgeCosts.get(val).get(i) + cost});
                }
            }
            return -1;
        }
    }

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */