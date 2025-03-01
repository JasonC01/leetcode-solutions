class Solution {
    public int[] applyOperations(int[] nums) {
        int[] ans = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] && nums[i] > 0) {
                ans[index++] = 2 * nums[i];
                nums[i + 1] = 0;
            } else if (nums[i] > 0) {
                ans[index++] = nums[i];
            }
        }
        ans[index] = nums[nums.length - 1];
        return ans;
    }
}