class Solution {
    int[] memo;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(nums, target);
    }
    
    public int dfs(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int i : nums) {
            ans += dfs(nums, target - i);
        }
        return memo[target] = ans;
    }
}