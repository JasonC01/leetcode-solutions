class Solution {
     public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int currSum = nums[0];
        int ans = Integer.MAX_VALUE;
        while (end < nums.length) {
            if (currSum >= target) {
                ans = Math.min(end - start + 1, ans);
                currSum -= nums[start++];
            } else {
                end++;
                if (end < nums.length) {
                    currSum += nums[end];
                }
            }
        }
        if (currSum >= target) {
            ans = Math.min(end - start + 1, ans);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}