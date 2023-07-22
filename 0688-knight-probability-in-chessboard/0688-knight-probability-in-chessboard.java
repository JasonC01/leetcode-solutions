class Solution {
    double ans = 0;
    double[][][] memo;
    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n + 1][n + 1][k + 1];
        knight(n, k, row, column, 1);

        return ans;
    }

    public double knight(int n, int k, int row, int column, double prob) {
        if (row > n - 1 || row < 0 || column > n - 1 || column < 0) {
        } else {
            if (k == 0) {
                ans += prob;
                return prob;
            } else {
                if (memo[row][column][k] != 0) {
                    ans += memo[row][column][k];
                    return memo[row][column][k];
                } else{
                    double newProb = prob / 8;
                    double res = knight(n, k - 1, row + 2, column + 1, newProb) +
                    knight(n, k - 1, row + 2, column - 1, newProb) +
                    knight(n, k - 1, row - 2, column + 1, newProb) +
                    knight(n, k - 1, row - 2, column - 1, newProb) +
                    knight(n, k - 1, row + 1, column + 2, newProb) +
                    knight(n, k - 1, row - 1, column + 2, newProb) +
                    knight(n, k - 1, row + 1, column - 2, newProb) +
                    knight(n, k - 1, row - 1, column - 2, newProb);
                    memo[row][column][k] = res;
                    return res;
                }
            }
        }
        return 0;
    }
}