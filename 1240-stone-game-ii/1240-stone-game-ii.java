class Solution {
    int[][][] memo;
    public int stoneGameII(int[] piles) {
        memo = new int[piles.length + 1][piles.length * 2 + 1][2];
        for (int[][] x : memo) {
            for (int[] y : x) {
                Arrays.fill(y , -1);
            }
        }
        return helper(piles, 0, 1, true, 0);
    }

    public int helper(int[] piles, int index, int m, boolean isAlice, int sum) {
        if (index > piles.length - 1) {
            return sum;
        }
        if (memo[index][m][isAlice ? 1 : 0] != -1) {
            return memo[index][m][isAlice ? 1 : 0] + sum;
        }
        int result = isAlice ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int currPiles = 0;
        for (int i = 1; i <= Math.min(2 * m, piles.length - index); i++) {
            currPiles += piles[index + i - 1];
            if (isAlice) {
                result = Math.max(helper(piles, index + i, Math.max(m, i), false, sum + currPiles), result);
            } else {
                result = Math.min(helper(piles, index + i, Math.max(m, i), true, sum), result);
            }
        }
        memo[index][m][isAlice ? 1 : 0] = result - sum;
        return result;
    }
}