class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
            if (i < n - 1) {
                adj.get(i).add(i + 1);
            }
        }
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            adj.get(query[0]).add(query[1]);
            Queue<Integer> q = new ArrayDeque<>();
            q.add(0);
            int lvl = 0;
            int lvlSize = 1;
            HashSet<Integer> visited = new HashSet<>();
            while (!q.isEmpty()) {
                int curr = q.poll();
                if (curr == n - 1) {
                    break;
                }
                lvlSize--;
                if (!visited.contains(curr)) {
                    visited.add(curr);
                    q.addAll(adj.get(curr));
                }
                if (lvlSize == 0) {
                    lvl++;
                    lvlSize = q.size();
                }
            }
            ans[index++] = lvl;
        }
        return ans;
    }
}