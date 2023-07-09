class Solution {
    public int longestOnes(int[] nums, int k) {
        int low = 0;
        int high = 0;
        int remaining = k;
        int ans = 0;
        while (high < nums.length) {
            if (nums[high] == 1) {
                high++;
            } else {
                if (remaining > 0) {
                    remaining--;
                    high++;
                } else {
                    ans = Math.max(ans, high - low);
                    while (nums[low] == 1) {
                        low++;
                    }
                    low++;
                    high++;
                }
            }
        }
        ans = Math.max(ans, high - low);
        return ans;
    }
}