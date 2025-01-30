class Solution {
    public int magnificentSets(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge: edges) {
            int from = edge[0];
            int to = edge[1];
            if (!adjList.containsKey(from)) {
                adjList.put(from, new ArrayList<>());
            }
            if (!adjList.containsKey(to)) {
                adjList.put(to, new ArrayList<>());
            }
            adjList.get(from).add(to);
            adjList.get(to).add(from);
        }
        HashSet<Integer> visited = new HashSet<>();
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (visited.contains(i)) {
                continue;
            }
            HashSet<Integer> nodesToBeTraversed = getConnectedComponents(adjList, i);
            int currMax = 0;
            for (int j : nodesToBeTraversed) {
                visited.add(j);
                Queue<Integer> q = new ArrayDeque<>();
                int level = 0;
                int levelSize = 1;
                q.add(j);
                int[] color = new int[n + 1];
                Arrays.fill(color, -1);
                color[j] = 0;
                while (!q.isEmpty()) {
                    int curr = q.poll();
                    visited.add(curr);
                    levelSize--;
                    for (int adj : adjList.getOrDefault(curr, new ArrayList<>())) {
                        if (color[adj] == -1) {
                            color[adj] = 1 - color[curr];
                            q.add(adj);
                        } else if (color[adj] == color[curr]) {
                            return -1;
                        }
                    }
                    if (levelSize == 0 && !q.isEmpty()) {
                        level++;
                        levelSize = q.size();
                    }
                }
                currMax = Math.max(level + 1, currMax);
            }
            ans += currMax;
        }
        return ans;
    }
    
    public HashSet<Integer> getConnectedComponents(HashMap<Integer, List<Integer>> adjList, int curr) {
        Queue<Integer> q = new ArrayDeque<>();
        HashSet<Integer> res = new HashSet<>();
        q.add(curr);
        while (!q.isEmpty()) {
            int val = q.poll();
            if (!res.contains(val)) {
                res.add(val);
                q.addAll(adjList.getOrDefault(val, new ArrayList<>()));
            }
        }
        return res;
    }
}