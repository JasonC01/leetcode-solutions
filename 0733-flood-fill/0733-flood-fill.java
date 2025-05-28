class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int initialColor = image[sr][sc];
        if (initialColor == color) return image;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || image[y][x] != initialColor) continue;
            image[y][x] = color;
            q.add(new int[]{y + 1, x});
            q.add(new int[]{y - 1, x});
            q.add(new int[]{y, x + 1});
            q.add(new int[]{y, x - 1});
        }
        return image;
    }
}