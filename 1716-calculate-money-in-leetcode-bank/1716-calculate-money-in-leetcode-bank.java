class Solution {
    public int totalMoney(int n) {
        return helper(n, 0);
    }
    
    public int helper(int n, int iter) {
        if (n == 0) {
            return 0;
        }
        int x = Math.min(7, n);
        return ((x + 1) * x / 2) + x * iter + helper(Math.max(0, n - 7), iter + 1);
    }
}