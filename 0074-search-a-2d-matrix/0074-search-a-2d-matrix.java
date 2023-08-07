class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = row * col - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            int y = Math.floorDiv(mid, col);
            int x = mid % col;
            if (matrix[y][x] == target) {
                return true;
            } else if (matrix[y][x] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return matrix[Math.floorDiv(low, col)][low % col] == target;
    }
}