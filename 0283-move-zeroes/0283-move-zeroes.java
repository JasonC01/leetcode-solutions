class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i : nums) {
            if (i != 0) {
                nums[index++] = i;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}