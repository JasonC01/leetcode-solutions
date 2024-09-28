class Solution {
    int[][] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        int res = helper(coins, 0, amount, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public int helper(int[] coins, int index, int amount, int count) {
        if (index > coins.length - 1) {
            return amount == 0 ? count : Integer.MAX_VALUE;
        }
        if (memo[index][amount] != -1) {
            return memo[index][amount] == Integer.MAX_VALUE ? Integer.MAX_VALUE : memo[index][amount] + count;
        }
        int ans = Integer.MAX_VALUE;
        int coinCount = 0;
        int minCount = Integer.MAX_VALUE;
        while (coinCount * coins[index] <= amount) {
            ans = Math.min(ans, helper(coins, index + 1, amount - (coinCount * coins[index]), coinCount + count));
            coinCount++;
        }
        memo[index][amount] = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans - count;
        return ans;
    }
}