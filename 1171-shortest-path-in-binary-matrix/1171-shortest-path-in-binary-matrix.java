class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        q.add(new int[]{0, 0});
        int size = q.size();
        int length = 1;
        while (!q.isEmpty()) {
            if (size == 0) {
                length++;
                size = q.size();
            }
            int[] curr = q.poll();
            size--;
            int x = curr[0];
            int y = curr[1];
            if (x > grid[0].length - 1 || x < 0 || y > grid.length - 1 || y < 0 || grid[y][x] == 1 || visited[y][x]) {
                continue;
            }
            visited[y][x] = true;
            if (x == grid[0].length - 1 && y == grid.length - 1) {
                return length;
            }

            q.add(new int[]{x + 1, y});
            q.add(new int[]{x - 1, y});
            q.add(new int[]{x, y + 1});
            q.add(new int[]{x, y - 1});
            q.add(new int[]{x + 1, y + 1});
            q.add(new int[]{x + 1, y - 1});
            q.add(new int[]{x - 1, y + 1});
            q.add(new int[]{x - 1, y - 1});
        }
        return -1;
    }


}