class Solution {
    public int shortestPathLength(int[][] graph) {
        int allVisited = (1 << graph.length) - 1;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < graph.length; i++) {
            queue.add(new int[]{i, 1 << i, 0});
        }
        boolean[][] visited = new boolean[allVisited][graph.length];
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currNode = curr[0];
            int currMask = curr[1];
            int currLength = curr[2];
            if (currMask == allVisited) {
                return currLength;
            }
            if (visited[currMask][currNode]) {
                continue;
            }
            visited[currMask][currNode] = true;
            for (int adj : graph[currNode]) {
                int newMask = currMask | 1 << adj;
                queue.add(new int[]{adj, newMask, currLength + 1});
            }
        }
        return -1; 
    }
}