class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph, 0, new HashMap<>());
    }

    public List<List<Integer>> dfs(int[][] graph, int currNode, HashMap<Integer, List<List<Integer>>> memo) {
        List<List<Integer>> ans = new ArrayList<>();
        if (currNode == graph.length - 1) {
            List<Integer> res = new ArrayList<>();
            res.add(currNode);
            ans.add(res);
            return ans;
        }
        // if (memo.containsKey(currNode)) return memo.get(currNode);
        for (int adj : graph[currNode]) {
            List<List<Integer>> res = dfs(graph, adj, memo);
            for (List<Integer> path : res) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(0, currNode);
                ans.add(newPath);
            }
        }
        return ans;
    }
}