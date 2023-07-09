class Solution {
    public int longestSubarray(int[] nums) {
        int low = 0;
        int high = 0;
        int remaining = 1;
        int ans = 0;
        while (high < nums.length) {
            if (nums[high] == 1) {
                high++;
            } else {
                if (remaining > 0) {
                    remaining--;
                    high++;
                } else {
                    ans = Math.max(ans, high - low - 1);
                    while (nums[low] == 1) {
                        low++;
                    }
                    low++;
                    high++;
                }
            }
        }
        ans = Math.max(ans, high - low - 1);
        return ans;
    }
}