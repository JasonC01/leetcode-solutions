class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        boolean isIncreasingMonotonic = true;
        for (int i = 1; i < nums.length; i++) {
            isIncreasingMonotonic &= nums[i] >= nums[i - 1];
        }
        boolean isDecreasingMonotonic = true;
        for (int i = 1; i < nums.length; i++) {
            isDecreasingMonotonic &= nums[i] <= nums[i - 1];
        }
        return isIncreasingMonotonic || isDecreasingMonotonic;
    }
}