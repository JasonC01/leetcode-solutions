class Solution {
    int[] memo;
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        memo = new int[nums.length];
        Arrays.fill(memo, 1);
        int res = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }
                res = Math.max(res, memo[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (memo[i] + ans.size() == res) {
                if (ans.isEmpty() || nums[i] % ans.get(ans.size() - 1) == 0) ans.add(nums[i]);
            }
        }
        return ans;
    }
}