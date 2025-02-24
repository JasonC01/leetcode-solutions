class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int[] edge : edges) {
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
        int[] bobPath = new int[adjList.size()];
        Arrays.fill(bobPath, Integer.MAX_VALUE);
        dfs(adjList, bob, bobPath, 0, new boolean[adjList.size()]);
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        int levelSize = 1;
        int ans = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int[] currArr = q.poll();
            int curr = currArr[0];
            int currSum = currArr[1];
            levelSize--;
            if (!visited.contains(curr)) {
                visited.add(curr);
                if (bobPath[curr] == level) {
                    currSum += amount[curr] / 2;
                } else if (bobPath[curr] > level) {
                    currSum += amount[curr];
                }
                if (curr != 0 && adjList.get(curr).size() == 1) {
                    ans = Math.max(ans, currSum);
                }
                for (int adj : adjList.get(curr)) {
                    q.add(new int[]{adj, currSum});
                }
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
        return ans;
    }
    
    public boolean dfs(HashMap<Integer, List<Integer>> adjList, int curr, int[] bobPath, int level, boolean[] visited) {
        if (curr == 0) {
            bobPath[curr] = level;
            return true;
        }
        visited[curr] = true;
        for (int adj : adjList.get(curr)) {
            if (!visited[adj]) {
                if (dfs(adjList, adj, bobPath, level + 1, visited)) {
                    bobPath[curr] = level;
                    return true;
                }
            }
        }
        return false;
    }
}
// 6 - 3 - 7 - 5
// |
// 1 - 4
//     |
// 0 - 2

// 4
// |
// 0 - 2 - 1 - 3
