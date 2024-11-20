class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                ans++;
                traverse(isConnected, i, visited);
            }
        }
        return ans;
    }

    public void traverse(int[][] map, int curr, boolean[] visited) {
        visited[curr] = true;
        for (int i = 0; i < map.length; i++) {
            if (!visited[i] && map[curr][i] == 1) {
                traverse(map, i, visited);
            }
        }
    }
}