class Solution {
     public boolean exist(char[][] board, String word) {
        boolean ans = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) ans |= dfs(board, i, j, word, new boolean[board.length][board[0].length]);
            }
        }
        return ans;
    }

    public boolean dfs(char[][] board, int y, int x, String word, boolean[][] visited) {
        if (word.isEmpty()) return true;
        if (y < 0 || x < 0 || y > board.length - 1 || x > board[0].length - 1 || visited[y][x] || board[y][x] != word.charAt(0)) return false;
        boolean ans = false;
        visited[y][x] = true;
        ans |= dfs(board, y + 1, x, word.substring(1), visited);
        ans |= dfs(board, y - 1, x, word.substring(1), visited);
        ans |= dfs(board, y, x + 1, word.substring(1), visited);
        ans |= dfs(board, y, x - 1, word.substring(1), visited);
        visited[y][x] = false;
        return ans;
    }
}