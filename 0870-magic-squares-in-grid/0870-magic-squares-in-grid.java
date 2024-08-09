class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagic(grid, j, i)) {
                    res++;
                }
            }
        }
        return res;
    }

    public boolean isMagic(int[][] grid, int startX, int startY) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int[] diagonals = new int[2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (set.contains(grid[startY + i][startX + j]) || grid[startY + i][startX + j] > 9 || grid[startY + i][startX + j] < 1) {
                    return false;
                } else {
                    set.add(grid[startY + i][startX + j]);
                }
                rows[i] += grid[startY + i][startX + j];
                cols[j] += grid[startY + i][startX + j];
                if (i == j) {
                    diagonals[0] += grid[startY + i][startX + j];
                }
                if (i + j == 2) {
                    diagonals[1] += grid[startY + i][startX + j];
                }
            }
        }
        int res = rows[0];
        for (int i : rows) {
            if (res != i) {
                return false;
            }
        }
        for (int i : cols) {
            if (res != i) {
                return false;
            }
        }
        for (int i : diagonals) {
            if (res != i) {
                return false;
            }
        }
        return true;
    }

}