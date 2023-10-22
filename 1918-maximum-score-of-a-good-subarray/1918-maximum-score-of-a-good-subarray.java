class Solution {
    public int maximumScore(int[] nums, int k) {
        int start = k - 1;
        int end = k + 1;
        int min = nums[k];
        int max = nums[k];
        while (start >= 0 || end <= nums.length - 1) {
            if (end == nums.length) {
                min = Math.min(nums[start], min);
                start--;
            } else if (start == -1) {
                min = Math.min(nums[end], min);
                end++;
            } else {
                if (nums[start] >= nums[end]) {
                    min = Math.min(nums[start], min);
                    start--;
                } else {
                    min = Math.min(nums[end], min);
                    end++;
                }
            }
            max = Math.max(max, min * (end - start - 1));
        }
        return max;
    }
}