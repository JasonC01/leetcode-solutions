class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < manager.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < manager.length; i++) {
            if (manager[i] == -1) {
                continue;
            }
            adjList.get(manager[i]).add(i);
        }
        return dfs(adjList, headID, informTime, 0);
    }

    public int dfs(List<List<Integer>> adjList, int currNode, int[] informTime, int timeTaken) {
        if (informTime[currNode] == 0) {
            return timeTaken;
        }
        int ans = 0;
        for (int i : adjList.get(currNode)) {
            ans = Math.max(ans, dfs(adjList, i, informTime, timeTaken + informTime[currNode]));
        }
        return ans;
    }
}