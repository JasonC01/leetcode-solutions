class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start = -1;
        int end = 0;
        int currSum = 0;
        int ans = Integer.MAX_VALUE;
        while (start < end && end <= nums.length) {
            if (currSum >= target) {
                ans = Math.min(ans, end - start - 1);
                currSum -= nums[++start];
            } else if (currSum < target) {
                if (end != nums.length) currSum += nums[end];
                end++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}