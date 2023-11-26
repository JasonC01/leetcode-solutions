class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] != 0 && i > 0) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
            int[] currRow = matrix[i].clone();
            Arrays.sort(currRow);
            for (int j = currRow.length - 1; j >= 0; j--) {
                ans = Math.max(ans, currRow[j] * (currRow.length - j));
            }
        }
        return ans;
    }
}