class Solution {
    public int largestAltitude(int[] gain) {
        int ans = 0;
        int curr = 0;
        for (int i : gain) {
            curr += i;
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}