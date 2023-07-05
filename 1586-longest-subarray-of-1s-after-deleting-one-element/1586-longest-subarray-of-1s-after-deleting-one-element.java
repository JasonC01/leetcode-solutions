class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        int zeroCount = 0;
        int ans = 0;
        while (end < nums.length) {
            if (nums[end] == 1) {
                end++;
            } else if (nums[end] == 0) {

                if (zeroCount > 0) {
                    ans = Math.max(ans, end - start - 1);
                    while (start < nums.length && nums[start] == 1) {
                        start++;
                    }
                    start++;
                    end++;
                } else {
                    zeroCount++;
                    end++;
                }
            }
        }
        ans = Math.max(ans, end - start - 1);
        return ans;
    }
}