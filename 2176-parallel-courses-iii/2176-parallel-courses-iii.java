class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[n];
        int[] maxTime = new int[n];

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : relations) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            inDegree[to]++;
            adjList.get(from).add(to);
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                // maxTime[i] = time[i];
                q.add(i);
            }
        }
        HashSet<Integer> completed = new HashSet<>();
        int levelSize = q.size();
        while (!q.isEmpty()) {
            int currNode = q.poll();
            levelSize--;
            if (!completed.contains(currNode)) {
                maxTime[currNode] += time[currNode];
                completed.add(currNode);
                for (int adj : adjList.get(currNode)) {
                    inDegree[adj]--;
                    maxTime[adj] = Math.max(maxTime[adj], maxTime[currNode]);
                    if (inDegree[adj] == 0) {
                        q.add(adj);
                    }
                }
            }
            if (levelSize == 0) {
                levelSize = q.size();
            }
        }
        int ans = 0;
        for (int i : maxTime) {
            ans = Math.max(i, ans);
        }
        return ans;
    }
}