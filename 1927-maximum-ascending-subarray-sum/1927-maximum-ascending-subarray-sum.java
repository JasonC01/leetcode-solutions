class Solution {
    public int maxAscendingSum(int[] nums) {
        int ans = 0;
        int currSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int prev = nums[i - 1];
            if (curr <= prev) {
                ans = Math.max(ans, currSum);
                currSum = 0;
            }
            currSum += curr;
        }
        ans = Math.max(ans, currSum);
        return ans;
    }
}