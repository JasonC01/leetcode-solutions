class Solution {
    int[] memo;
    public boolean checkPowersOfThree(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return helper(n, 0);
    }
    
    public boolean helper(int n, int pow) {
        if (n == 0) {
            return true;
        }
        if (n < 0 || Math.pow(3, pow) > n) {
            return false;
        }
        if (memo[n] != -1) {
            return memo[n] == 1;
        }
        return helper(n - (int) Math.pow(3, pow), pow + 1) || helper(n, pow + 1);
    }
}