class Solution {
    int[] memo = new int[46];
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}