class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxCount = 0;
        int maxVal = Integer.MIN_VALUE;
        for (int i : nums) {
            maxVal = Math.max(maxVal, i);
        }
        long ans = 0;
        int low = -1;
        int high = 0;
        while (high <= nums.length) {
            if (high < nums.length) {
                if (nums[high] == maxVal) maxCount++;
            }
            
            while (maxCount >= k) {
                ans += nums.length - high;
                if (nums[low + 1] == maxVal) maxCount--;
                low++;
            }
            high++;
        }
        return ans;
    }
}