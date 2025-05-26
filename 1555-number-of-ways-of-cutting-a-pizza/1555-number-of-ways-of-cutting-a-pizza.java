class Solution {
    int mod = (int) (1e9 + 7);
    public int ways(String[] pizza, int k) {
//        dp[i][j] = number of ways to cut pizza with top-left corner = (i, j)
//        dp[i][j] = sum (dp[i + k][k] for 1 < k < len(pizza) if we can cut at k) +
//                sum (dp[i][j + k] for 1 < k < len(pizza[0]) if we can cut at k)
//
//        criteria for cutting at k
//                - pref[k] - pref[k - 1] > 0. Need at least 1 apple
        int[][][] memo = new int[pizza.length][pizza[0].length()][k];
        int[][] appleCount = new int[pizza.length + 1][pizza[0].length() + 1];
        for (int i = pizza.length - 1; i >= 0; i--) {
            for (int j = pizza[0].length() - 1; j >= 0; j--) {
                appleCount[i][j] = (pizza[i].charAt(j) == 'A' ? 1 : 0) + appleCount[i + 1][j] + appleCount[i][j + 1] - appleCount[i + 1][j + 1];
            }
        }
        if (appleCount[0][0] == 0) return 0;
        // System.out.println(Arrays.deepToString(appleCount));
        for (int[][] arr : memo)
            for (int[] x : arr)
                Arrays.fill(x, -1);
        return helper(pizza, k - 1, 0, 0, memo, appleCount);
    }

    public int helper(String[] pizza, int k, int y, int x, int[][][] memo, int[][] appleCount) {
        // System.out.println(Arrays.toString(new int[]{y, x, k}));
        if (k == 0) return 1;
        if (y == pizza.length - 1 && x == pizza[0].length()) return 0;
        int ans = 0;
        if (memo[y][x][k] != -1) return memo[y][x][k];
        for (int i = 1; i + y < pizza.length; i++) {
            if (appleCount[i + y][x] < appleCount[y][x] && appleCount[y + i][x] > 0) {
                ans = (ans + helper(pizza, k - 1, i + y, x, memo, appleCount)) % mod;
            }
        }
        for (int i = 1; i + x < pizza[0].length(); i++) {
            if (appleCount[y][i + x] < appleCount[y][x] && appleCount[y][x + i] > 0) {
                ans = (ans + helper(pizza, k - 1, y, x + i, memo, appleCount)) % mod;
            }
        }
        memo[y][x][k] = ans;
        return ans;
    }
}