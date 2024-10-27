class Solution {
    int[][][] memo;
    public int countSquares(int[][] matrix) {
        int ans = 0;
        memo = new int[matrix.length][matrix[0].length][301];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    memo[i][j][1] = 1;
                    ans++;
                }
            }
        }
        
        for (int s = 2; s <= Math.min(matrix.length, matrix[0].length); s++) {
            for (int i = 0; i <= matrix.length - s; i++) {
                for (int j = 0; j <= matrix[0].length - s; j++) {
                    int res = dp(matrix, j, i, s);
                    ans += res;
                    
                }
            }
        }
        return ans;
    }

    public int dp(int[][] matrix, int x, int y, int size) {
        if (memo[y][x][size - 1] == 0) {
            return 0;
        }
        for (int i = 0; i < size; i++) {
            if (matrix[y + size - 1][x + i] != 1) {
                memo[y][x][size] = 0;
                return 0;
            }
        }
        for (int i = 0; i < size; i++) {
            if (matrix[y + i][x + size - 1] != 1) {
                memo[y][x][size] = 0;
                return 0;
            }
        }
        memo[y][x][size] = 1;
        return 1;
    }
}