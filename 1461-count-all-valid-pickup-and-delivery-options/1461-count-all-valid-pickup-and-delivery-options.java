class Solution {
    int mod = (int) (1e9 + 7);
    long[][] memo;
    public int countOrders(int n) {
        memo = new long[n + 1][n + 1];
        return (int) helper(n, 0);
    }

    public long helper(int pickup, int deliver) {
        if (pickup == 0 && deliver == 0) {
            return 1;
        }
        if (memo[pickup][deliver] != 0) {
            return memo[pickup][deliver];
        }
        long ans = 0;
        if (deliver > 0) {
            ans = (helper(pickup, deliver - 1) * deliver) % mod;
        }
        if (pickup > 0) {
            ans = (ans + (helper(pickup - 1, deliver + 1) * pickup) % mod) % mod;
        }
        return memo[pickup][deliver] = ans;
    }
}