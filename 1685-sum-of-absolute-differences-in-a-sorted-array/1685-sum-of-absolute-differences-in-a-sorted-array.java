class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (nums[i] * (i + 1) - prefixSum[i]) + ((prefixSum[prefixSum.length - 1] - prefixSum[i]) - (nums[i] * (nums.length - i - 1)));
        }
        return ans;
    }
}