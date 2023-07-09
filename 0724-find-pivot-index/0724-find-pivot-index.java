class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length + 1];
        int[] suffixSum = new int[nums.length + 1];
        prefixSum[1] = nums[0];
        suffixSum[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
            suffixSum[nums.length - i - 1] = suffixSum[nums.length - i] + nums[nums.length - i - 1];
        }
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum[i] == suffixSum[i + 1]) {
                return i;
            }
        }
        return ans;
    }
}