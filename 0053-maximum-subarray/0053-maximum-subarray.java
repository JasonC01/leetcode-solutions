class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int i : nums) {
            if (res < 0) {
                res = 0;
            }
            res += i;
            ans = Math.max(ans, res);
        }
        return ans;
    }
}