class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 0;
        int decreasingStart = 0;
        int increasingStart = 0;
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (curr > prev) {
                ans = Math.max(ans, i - decreasingStart);
                decreasingStart = i;
            } else if (curr < prev) {
                ans = Math.max(ans, i - increasingStart);
                increasingStart = i;
            } else {
                ans = Math.max(ans, i - decreasingStart);
                ans = Math.max(ans, i - increasingStart);
                decreasingStart = i;
                increasingStart = i;
            }
        }
        ans = Math.max(ans, nums.length - decreasingStart);
        ans = Math.max(ans, nums.length - increasingStart);
        return ans;
    }
}