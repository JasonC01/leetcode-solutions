class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0, new LinkedList<>());
    }

    public List<List<Integer>> dfs(int[][] graph, int currNode, LinkedList<Integer> path) {
        List<List<Integer>> ans = new ArrayList<>();
        if (currNode == graph.length - 1) {
            path.addLast(currNode);
            ans.add(new ArrayList<>(path));
            path.removeLast();
            return ans;
        }
        path.addLast(currNode);
        for (int adj : graph[currNode]) {
            ans.addAll(dfs(graph, adj, path));
        }
        path.removeLast();
        return ans;
    }

}