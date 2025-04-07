class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % 2 == 1) {
            return false;
        }
        memo = new int[nums.length][total + 1];
        return helper(nums, 0, 0, total / 2);
    }

    public boolean helper(int[] nums, int index, int currentSum, int target) {
        if (currentSum == target) {
            return true;
        }
        if (index > nums.length - 1 || currentSum > target) {
            return false;
        }
        if (memo[index][currentSum] != 0) {
            return memo[index][currentSum] == 1;
        }
        boolean res = helper(nums, index + 1, currentSum + nums[index], target);
        res |= helper(nums, index + 1, currentSum, target);
        memo[index][currentSum] = res ? 1 : -1;
        return res;
    }
}