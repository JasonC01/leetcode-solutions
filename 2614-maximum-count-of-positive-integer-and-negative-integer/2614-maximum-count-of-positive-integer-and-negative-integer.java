class Solution {
    public int maximumCount(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while (high >= 0 && nums[high] > 0) {
            high--;
        }
        while (low < nums.length && nums[low] < 0) {
            low++;
        }
        return Math.max(nums.length - high - 1, low);
    }
}