class Solution {
     public int minReorder(int n, int[][] connections) {
        List<HashSet<Integer>> actualAdj = new ArrayList<>();
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            actualAdj.add(new HashSet<>());
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < connections.length; i++) {
            int from = connections[i][0];
            int to = connections[i][1];
            actualAdj.get(from).add(to);
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        boolean[] visited = new boolean[n];
        int reversed = 0;
        while (!q.isEmpty()) {
            int currCity = q.poll();
            visited[currCity] = true;
            for (int adj : adjList.get(currCity)) {
                if (!visited[adj]) {
                    if (actualAdj.get(currCity).contains(adj)) {
                        reversed++;
                    }
                    q.add(adj);
                }
            }
        }
        return reversed;
    }
}