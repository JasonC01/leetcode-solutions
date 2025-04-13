class Solution {
    int mod = (int) (1e9 + 7);
    public int countGoodNumbers(long n) {
        long res =  ((power(5, Math.floorDiv(n, 2)) * power(4, Math.floorDiv(n, 2))) % mod);
        if (n % 2 == 1) res = (res * 5) % mod;
        return (int) res;
    }

    public long power(int x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long ans = 1;
        if (n % 2 == 1) {
            ans *= x;
            n--;
        }
        long res = power(x, n / 2);
        ans = (ans * res) % mod;
        ans = (ans * res) % mod;
        return ans;
    }
}