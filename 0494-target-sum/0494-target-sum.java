class Solution {
    HashMap<Integer, HashMap<Integer, Integer>> memo = new HashMap<>();
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, 0, 0, target);
    }

    public int helper(int[] nums, int index, int sum, int target) {
        if (index > nums.length - 1) {
            return sum == target ? 1 : 0;
        }
        if (memo.containsKey(index) && memo.get(index).containsKey(sum)) {
            return memo.get(index).get(sum);
        }
        int ans = helper(nums, index + 1, sum + nums[index], target) + helper(nums, index + 1, sum - nums[index], target);
        if (!memo.containsKey(index)) {
            memo.put(index, new HashMap<>());
        }
        memo.get(index).put(sum, ans);
        return ans;
    }
}