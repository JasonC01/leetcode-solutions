class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        return helper(nums, 0, nums.length - 1, true, 0, new int[nums.length + 1][nums.length + 1]) >= Math.ceil((double) total / 2);
    }
    public int helper(int[] nums, int low, int high, boolean alice, int points, int[][] memo) {
        if (low == high) {
            return alice ? points + nums[low] : points;
        }
        if (memo[low][high] != 0) {
            return memo[low][high] + points;
        }
        if (alice) {
            memo[low][high] = Math.max(helper(nums, low + 1, high, false, points + nums[low], memo),
                    helper(nums, low, high - 1, false, points + nums[high], memo)) - points;
            return memo[low][high] + points;
        } else {
            memo[low][high] = Math.min(helper(nums, low + 1, high, true, points, memo),
                    helper(nums, low, high - 1, true, points, memo)) - points;
            return memo[low][high] + points;
        }
    }
}