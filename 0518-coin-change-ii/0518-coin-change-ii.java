class Solution {
    int[][] memo;

    public int change(int amount, int[] coins) {
        memo = new int[amount + 1][coins.length + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return helper(amount, 0, coins);
    }
    
    public int helper(int amount, int index, int[] coins) {
        
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }
        if (index > coins.length - 1) {
            return 0;
        }
        if (memo[amount][index] != -1) {
            return memo[amount][index];
        }
        return memo[amount][index] = helper(amount - coins[index], index, coins) + helper(amount, index + 1, coins);
    }
}