class Solution {
    public int maximumDetonation(int[][] bombs) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < bombs.length; i++) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];
            adjList.add(new ArrayList<>());
            for (int j = 0; j < bombs.length; j++) {
                if (j == i) {
                    continue;
                }
                int currX = bombs[j][0];
                int currY = bombs[j][1];
                if (inRadius(x, y, currX, currY, r)) {

                    adjList.get(i).add(j);
                }
            }
        }
        int[] memo = new int[bombs.length];
        int ans = 0;
        for (int i = 0; i < bombs.length; i++) {
            ans = Math.max(ans, dfs(adjList, i, new boolean[bombs.length]));
        }

        return ans;
    }

    public int dfs(List<List<Integer>> adjList, int currBomb, boolean[] visited) {

        if (visited[currBomb]) {
            return 0;
        }
        visited[currBomb] = true;
        int ans = 1;
        for (int i : adjList.get(currBomb)) {
            ans += dfs(adjList, i, visited);
        }
        return ans;
    }

    public boolean inRadius(int x, int y, int xx, int yy, int r) {
        return Math.sqrt(Math.pow(yy - y, 2) + Math.pow(xx - x, 2)) <= r;
    }

}