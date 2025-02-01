class Solution {
    public int maximalSquare(char[][] matrix) {
        int low = 0;
        int high = Math.min(matrix.length, matrix[0].length);
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (isPossible(matrix, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low * low;
    }
    
    public boolean isPossible(char[][] matrix, int squareSize) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] isRowPossible = new boolean[m][n - squareSize + 1];
        for (int i = 0; i < m; i++) {
            int currSum = 0;
            for (int j = 0; j < squareSize; j++) {
                currSum += matrix[i][j] == '1' ? 1 : 0;
            }
            isRowPossible[i][0] = currSum == squareSize;
            for (int j = 1; j < n - squareSize + 1; j++) {
                currSum -= matrix[i][j - 1] == '1' ? 1 : 0;
                currSum += matrix[i][j + squareSize - 1] == '1' ? 1 : 0;
                isRowPossible[i][j] = currSum == squareSize;
            }
        }
        for (int i = 0; i < n - squareSize + 1; i++) {
            for (int j = 0; j < m - squareSize + 1; j++) {
                if (isRowPossible[j][i]) {
                    boolean possible = true;
                    for (int k = j; k < j + squareSize; k++) {
                        possible &= isRowPossible[k][i];
                    }
                    if (possible) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}