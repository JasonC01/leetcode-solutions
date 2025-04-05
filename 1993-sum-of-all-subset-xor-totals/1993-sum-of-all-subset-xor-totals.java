class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper(int[] nums, int index, int currVal) {
        if (index > nums.length - 1) {
            return currVal;
        }
        int ans = 0;
        ans += helper(nums, index + 1, currVal ^ nums[index]);
        ans += helper(nums, index + 1, currVal);
        return ans;
    }
}