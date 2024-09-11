class Solution {
    public int minBitFlips(int start, int goal) {
        int res = start ^ goal;
        int ans = 0;
        while (res > 0) {
            ans += res % 2;
            res /= 2;
        }
        return ans;
    }
}