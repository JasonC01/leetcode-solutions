class Solution {

    public boolean check(int[] nums) {
        int leftMin = Integer.MAX_VALUE;
        int rightMax = Integer.MIN_VALUE;
        int prev = 0;
        int index = 0;
        while (index < nums.length && nums[index] >= prev) {
            leftMin = Math.min(leftMin, nums[index]);
            prev = nums[index];
            index++;
        }
        if (index < nums.length) {
            prev = 0;
            while (index < nums.length && nums[index] >= prev) {
                rightMax = Math.max(rightMax, nums[index]);
                prev = nums[index];
                index++;
            }
        }
        return index == nums.length && leftMin >= rightMax;
    }
}