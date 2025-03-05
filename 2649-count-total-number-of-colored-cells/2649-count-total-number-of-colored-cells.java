class Solution {
    public long coloredCells(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        long ans = 1;
        int curr = 2;
        for (int i = 1; i < n; i++) {
            ans += 4L * curr - 4;
            curr++;
        }
        return ans;
    }
}