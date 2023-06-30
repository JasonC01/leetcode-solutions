class Solution {
    int[][] grid;
    int row;
    int col;

    public int latestDayToCross(int row, int col, int[][] cells) {
        grid = new int[row][col];
        this.row = row;
        this.col = col;
        int ans = 0;
        for (int[] cell : cells) {
            int x = cell[1] - 1;
            int y = cell[0] - 1;
            grid[y][x] = 1;
        }
        
        return bSearch(cells);
    }

    public boolean isPossible(int x, int y, boolean[][] visited, int[][] possible) {
        if (x < 0 || x > grid[0].length - 1 || y < 0 || y > grid.length - 1 || visited[y][x] || grid[y][x] == 1) {
            return false;
        }
        if (y == grid.length - 1) {
            possible[y][x] = grid[y][x] == 0 ? 1 : 0;
            return grid[y][x] == 0;
        }
        if (possible[y][x] != -1) {
            return possible[y][x] == 1;
        }
        visited[y][x] = true;
        boolean right = isPossible(x + 1, y, visited, possible);
        boolean left = isPossible(x - 1, y, visited, possible);
        boolean up = isPossible(x, y + 1, visited, possible);
        boolean down = isPossible(x, y - 1, visited, possible);
        visited[y][x] = false;
        boolean ans = right || left || up || down;
        possible[y][x] = ans ? 1 : 0;
        return ans;
    }

    public int bSearch(int[][] cells) {
        int low = 0;
        int high = cells.length - 1;
        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            for (int i = high; i > mid; i--) {
                int x = cells[i][1] - 1;
                int y = cells[i][0] - 1;
                grid[y][x] = 0;
            }
            int[][] possibleArr = new int[row][col];
            for (int[] arr : possibleArr) {
                Arrays.fill(arr, -1);
            }
            boolean possible = false;
            for (int xCoor = 0; xCoor < col; xCoor++) {
                if (isPossible(xCoor, 0, new boolean[row][col], possibleArr)) {
                    possible = true;
                    break;
                }
            }
            if (possible) {
                low = mid;
                for (int i = mid + 1; i <= high; i++) {
                    int x = cells[i][1] - 1;
                    int y = cells[i][0] - 1;
                    grid[y][x] = 1;
                }
            } else {
                grid[cells[mid][0] - 1][cells[mid][1] - 1] = 0;
                high = mid - 1;
            }
        }
        return low + 1;
    }

}