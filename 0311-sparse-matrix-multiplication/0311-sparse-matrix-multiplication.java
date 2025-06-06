class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int m = mat2[0].length;
        int k = mat2.length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int x = 0; x < k; x++) {
                    res[i][j] += mat1[i][x] * mat2[x][j];
                }
            }
        }
        return res;
    }
}