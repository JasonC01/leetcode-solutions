class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int level = 0;
        int levelSize = q.size();
        int[][] res = new int[mat.length][mat[0].length];
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while (!q.isEmpty()) {
            int[] currPos = q.poll();
            int y = currPos[0];
            int x = currPos[1];
            levelSize--;
            if (x < 0 || y < 0 || x > mat[0].length - 1 || y > mat.length - 1 || visited[y][x]) {} else {
                visited[y][x] = true;
                res[y][x] = level;
                q.add(new int[]{y + 1, x});
                q.add(new int[]{y - 1, x});
                q.add(new int[]{y, x + 1});
                q.add(new int[]{y, x - 1});
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
        return res;
    }
}