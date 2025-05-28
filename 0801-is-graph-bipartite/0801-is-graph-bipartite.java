class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] assignments = new int[n];
        Arrays.fill(assignments, -1);
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            if (assignments[i] != -1) continue;
            q.add(new int[]{i, 0});
            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int node = curr[0];
                int assignment = curr[1];
                int nextAssignment = (curr[1] + 1) % 2;
                if (assignments[node] == -1) {
                    assignments[node] = assignment;
                    for (int adj : graph[node]) {
                        q.add(new int[]{adj, nextAssignment});
                    }
                }
                if (assignments[node] != assignment) return false;
            }
        }
        return true;
    }
}