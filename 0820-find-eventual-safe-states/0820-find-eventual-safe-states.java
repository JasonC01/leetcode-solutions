class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[] terminalNodes = new boolean[graph.length];
        boolean[] visited = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            terminalNodes[i] = graph[i].length == 0;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (isTerminal(graph, i, terminalNodes, visited)) ans.add(i);
        }
        return ans;
    }

    public boolean isTerminal(int[][] graph, int currNode, boolean[] terminalNodes, boolean[] visited) {
        if (terminalNodes[currNode]) {
            return true;
        }
        if (visited[currNode]) {
            return false;
        }
        visited[currNode] = true;
        for (int adj : graph[currNode]) {
            if (!isTerminal(graph, adj, terminalNodes, visited)) {
                visited[currNode] = false;
                return false;
            }
        }
        visited[currNode] = false;
        terminalNodes[currNode] = true;
        return true;
    }
}