class Solution {
    public int longestNiceSubarray(int[] nums) {
        long mask = nums[0];
        int low = 0;
        int ans = 1;
        for (int i = 1; i < nums.length; i++) {
            if ((mask & nums[i]) == 0) {
                mask += nums[i];
            } else {
                ans = Math.max(i - low, ans);
                while (low < i && ((mask & nums[i]) != 0)) {
                    mask -= nums[low++];
                }
                mask += nums[i];
            }
        }
        ans = Math.max(nums.length - low, ans);
        return ans;
    }
}