class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        memo = new int[nums.length + 1][total + 1];
        return helper(nums, 0, 0, total);
    }

    public boolean helper(int[] nums, int index, int sum, int total) {
        if (index > nums.length - 1) return sum * 2 == total;
        if (sum * 2 == total) return true;
        if (sum * 2 > total) return false;
        if (memo[index][sum] != 0) return memo[index][sum] == 1;
        boolean res = helper(nums, index + 1, sum + nums[index], total) || helper(nums, index + 1, sum, total);
        memo[index][sum] = res ? 1 : -1;
        return res;
    }
}