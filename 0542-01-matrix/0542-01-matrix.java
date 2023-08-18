class Solution {
    int[][] res;
    public int[][] updateMatrix(int[][] mat) {
        res = new int[mat.length][mat[0].length];
        helper(mat);
        return res;
    }

    public void helper(int[][] mat) {
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[]{j, i});
                }
            }
        }
        int level = 0;
        int levelSize = q.size();
        boolean[][] visited = new boolean[mat.length][mat[0].length];
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            levelSize--;
            int xCurr = curr[0];
            int yCurr = curr[1];
            if (xCurr > mat[0].length - 1 || xCurr < 0 || yCurr > mat.length - 1 || yCurr < 0 || visited[yCurr][xCurr]) {}
            else {
                visited[yCurr][xCurr] = true;
                res[yCurr][xCurr] = level;
                q.add(new int[]{xCurr + 1, yCurr});
                q.add(new int[]{xCurr - 1, yCurr});
                q.add(new int[]{xCurr, yCurr + 1});
                q.add(new int[]{xCurr, yCurr - 1});
            }
            if (levelSize == 0) {
                level++;
                levelSize = q.size();
            }
        }
    }
}