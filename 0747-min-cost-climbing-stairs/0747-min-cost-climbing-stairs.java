class Solution {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length];
        return Math.min(helper(cost, 0, 0), helper(cost, 1, 0));
    }

    public int helper(int[] cost, int index, int totalCost) {
        if (index > cost.length - 1) {
            return totalCost;
        }
        if (memo[index] != 0) {
            return totalCost + memo[index];
        }
        memo[index] = Math.min(helper(cost, index + 1, totalCost + cost[index]), helper(cost, index + 2, totalCost + cost[index])) - totalCost;
        return memo[index] + totalCost;
    }
}