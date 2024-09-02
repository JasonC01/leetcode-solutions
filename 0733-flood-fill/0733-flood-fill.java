class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        int initColor = image[sr][sc];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            if (y < 0 || y > image.length - 1 || x < 0 || x > image[0].length - 1 || visited[y][x] || image[y][x] != initColor) {
                continue;
            }
            visited[y][x] = true;
            image[y][x] = color;
            q.add(new int[]{y + 1, x});
            q.add(new int[]{y - 1, x});
            q.add(new int[]{y, x + 1});
            q.add(new int[]{y, x - 1});
        }
        return image;
    }
}