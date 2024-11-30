class Solution {
    public int[][] validArrangement(int[][] pairs) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, Integer> outDegree = new HashMap<>();
        HashSet<Integer> nodes = new HashSet<>();
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            if (!adj.containsKey(start)) {
                adj.put(start, new ArrayList<>());
            }
            nodes.add(start);
            nodes.add(end);
            inDegree.merge(end, 1, (a, b) -> a + 1);
            outDegree.merge(start, 1, (a, b) -> a + 1);
            adj.get(start).add(end);
        }
        int start = -1;
        for (int i : outDegree.keySet()) {
            if (outDegree.get(i) == inDegree.getOrDefault(i, 0) + 1) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            start = pairs[0][0];
        }
        List<Integer> res = new ArrayList<>();
        dfs(start, res, adj, new HashSet<>());
        int[][] ans = new int[pairs.length][2];
        for (int i = 1; i < res.size(); i++) {
            ans[i - 1] = new int[]{res.get(i - 1), res.get(i)};
        }
        return ans;
    }

    public void dfs(int curr, List<Integer> res, HashMap<Integer, List<Integer>> adj, HashSet<Integer> visited) {
        while (!adj.getOrDefault(curr, new ArrayList<>()).isEmpty()) {
            int next = adj.getOrDefault(curr, new ArrayList<>()).remove(0);
            dfs(next, res, adj, visited);
        }
        res.add(0, curr);
    }
}