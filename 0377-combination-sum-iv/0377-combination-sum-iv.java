class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return helper(nums, target, 0);
    }

    public int helper(int[] nums,  int target, int sum) {
        if (sum == target) return 1;
        if (sum > target) return 0;
        if (memo[sum] != -1) return memo[sum];
        int ans = 0;
        for (int i : nums) {
            ans += helper(nums, target, sum + i);
        }
        memo[sum] = ans;
        return ans;
    }

}