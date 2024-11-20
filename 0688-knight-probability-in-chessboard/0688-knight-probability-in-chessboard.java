class Solution {
    int[][] moves = new int[][]{new int[]{2, 1},
            new int[]{2, -1},
            new int[]{1, 2},
            new int[]{-1, 2},
            new int[]{-2, 1},
            new int[]{-2, -1},
            new int[]{1, -2},
            new int[]{-1, -2}
    };
    double[][][] memo;
    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n + 1][n + 1][k + 1];
        for (double[][] i : memo) {
            for (double[] j : i) {
                Arrays.fill(j, -1);
            }
        }
        return dfs(n, k, row, column, 1.0);
    }

    public double dfs(int n, int k, int y, int x, double prob) {
        if (x < 0 || y < 0 || x > n - 1 || y > n - 1) {
            return 0;
        }
        if (k == 0) {
            return prob;
        }
        if (memo[y][x][k] != -1) {
            return memo[y][x][k];
        }
        double ans = 0;
        for (int[] move : moves) {
            ans += dfs(n, k - 1, y + move[0], x + move[1], prob / 8);
        }
        memo[y][x][k] = ans;
        return ans;
    }


}