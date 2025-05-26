class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjList.computeIfAbsent(from, x -> new ArrayList<>());
            adjList.get(from).add(to);
        }
        int ans = 0;
        HashMap<Integer, HashMap<Character, Integer>> memo = new HashMap<>();
        for (int i = 0; i < colors.length(); i++) {
            HashMap<Character, Integer> res = dfs(colors, adjList, i, memo, new HashSet<>());
            if (res.containsKey('-')) return -1;
            for (int count : res.values()) {
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }

    public HashMap<Character, Integer> dfs(String colors, HashMap<Integer, List<Integer>> adjList, int curr, HashMap<Integer, HashMap<Character, Integer>> memo, HashSet<Integer> visited) {
        if (visited.contains(curr)) {
            HashMap<Character, Integer> ans = new HashMap<>();
            ans.put('-', -1);
            return ans;
        }
        if (memo.containsKey(curr)) return memo.get(curr);
        visited.add(curr);
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int adj : adjList.getOrDefault(curr, new ArrayList<>())) {
            HashMap<Character, Integer> res = dfs(colors, adjList, adj, memo, visited);
            for (char key : res.keySet()) {
                ans.merge(key, res.get(key), Math::max);
            }
        }
        visited.remove(curr);
        ans.merge(colors.charAt(curr), 1, (a, b) -> a + 1);
        memo.put(curr, ans);
        return ans;
    }
}