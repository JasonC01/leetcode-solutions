class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') q.add(new int[]{i, 0});
            if (board[i][m - 1] == 'O') q.add(new int[]{i, m - 1});
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') q.add(new int[]{0, j});
            if (board[n - 1][j] == 'O') q.add(new int[]{n - 1, j});
        }
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            if (y < 0 || x < 0 || y > n - 1 || x > m - 1 || visited[y][x] || board[y][x] == 'X') continue;
            visited[y][x] = true;
            q.add(new int[]{y + 1, x});
            q.add(new int[]{y - 1, x});
            q.add(new int[]{y, x + 1});
            q.add(new int[]{y, x - 1});
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }
}