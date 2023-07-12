class Solution {
    boolean[] isSafe;
    boolean[] checked;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        isSafe = new boolean[graph.length];
        checked = new boolean[graph.length];
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (checkSafe(graph, i, new boolean[graph.length]))  {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public boolean checkSafe(int[][] graph, int currNode, boolean[] visited) {
        if (graph[currNode].length == 0) {
            return isSafe[currNode] = true;
        }
        if (checked[currNode]) {
            return isSafe[currNode];
        }
        if (visited[currNode]) {
            return false;
        }
        boolean ans = true;
        visited[currNode] = true;
        for (int adj : graph[currNode]) {
            ans &= checkSafe(graph, adj, visited);
        }
        checked[currNode] = true;
        return isSafe[currNode] = ans;
    }
}