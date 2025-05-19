class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<HashSet<Pair<Integer, Integer>>> res = new HashSet<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    HashSet<Pair<Integer, Integer>> set = new HashSet<>();
                    markVisited(grid, visited, set, i, j);
                    res.add(set);
                }
            }
        }
        return res.size();
    }

    public void markVisited(int[][] grid, boolean[][] visited, HashSet<Pair<Integer, Integer>> set, int currY, int currX) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{currY, currX});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            if (x < 0 || y < 0 || x > grid[0].length - 1 || y > grid.length - 1 || visited[y][x] || grid[y][x] == 0) continue;
            set.add(new Pair<>(y - currY, x - currX));
            visited[y][x] = true;
            q.add(new int[]{y, x + 1});
            q.add(new int[]{y, x - 1});
            q.add(new int[]{y + 1, x});
            q.add(new int[]{y - 1, x});
        }
    }

}