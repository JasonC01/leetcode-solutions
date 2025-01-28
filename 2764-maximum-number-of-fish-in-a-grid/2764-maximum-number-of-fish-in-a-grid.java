class Solution {
    public int findMaxFish(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{i, j});
                    int currSum = 0;
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int y = curr[0];
                        int x = curr[1];
                        if (y < 0 || x < 0 || y > grid.length - 1 || x > grid[0].length - 1 || visited[y][x] || grid[y][x] == 0) {
                            continue;
                        }
                        visited[y][x] = true;
                        currSum += grid[y][x];
                        queue.add(new int[]{y + 1, x});
                        queue.add(new int[]{y - 1, x});
                        queue.add(new int[]{y, x + 1});
                        queue.add(new int[]{y, x - 1});
                    }
                    ans = Math.max(ans, currSum);
                }
            }
        }
        return ans;
    }
}