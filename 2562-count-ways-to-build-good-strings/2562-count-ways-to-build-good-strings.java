class Solution {
    int[] memo;
    int mod = (int) (1e9 + 7);
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        return helper(low, high, zero, one, 0);
    }

    public int helper(int low, int high, int zero, int one, int currentLength) {
        int ans = 0;
        if (currentLength >= low && currentLength <= high) {
            ans++;
        }
        if (currentLength > high) {
            return 0;
        }
        if (memo[currentLength] != -1) {
            return memo[currentLength];
        }
        ans = (ans + helper(low, high, zero, one, currentLength + zero)) % mod;
        ans = (ans + helper(low, high, zero, one, currentLength + one)) % mod;
        memo[currentLength] = ans;
        return ans;
    }
}