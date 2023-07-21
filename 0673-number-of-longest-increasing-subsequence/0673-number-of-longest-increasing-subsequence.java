class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] memo = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        memo[memo.length - 1] = 1;
        count[count.length - 1] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int maxCount = 1;
            int currMax = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    if (memo[j] > currMax) {
                        currMax = memo[j];
                        maxCount = count[j];
                    } else if (memo[j] == currMax) {
                        maxCount += count[j];
                    }
                }
            }
            memo[i] = currMax + 1;
            count[i] = maxCount;
            max = Math.max(max, currMax + 1);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (memo[i] == max) {
                ans += count[i];
            }
        }
        return ans;
    }
}