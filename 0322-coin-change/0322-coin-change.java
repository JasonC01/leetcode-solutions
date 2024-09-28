class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        memo[0] = 0;
        for (int coin : coins) {
            if (coin <= amount) {
                memo[coin] = 1;
            }
        }
        for (int i = 1; i <= amount; i++) {
            int val = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                }
                int counterpart = memo[i - coin];
                if (counterpart == Integer.MAX_VALUE) {
                    continue;
                }
                val = Math.min(val, counterpart + 1);
            }
            memo[i] = val;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
    }
}