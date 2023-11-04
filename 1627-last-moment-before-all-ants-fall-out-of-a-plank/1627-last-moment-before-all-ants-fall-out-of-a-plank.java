class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int i : left) {
            ans = Math.max(i, ans);
        }
        for (int i : right) {
            ans = Math.max(n - i, ans);
        }
        return ans;
    }
}