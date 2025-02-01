class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean isEven = nums[0] % 2 != 0;
        for (int i : nums) {
            if ((isEven && (i % 2 == 0)) || (!isEven && (i % 2 != 0))) {
                return false;
            }
            isEven = !isEven;
        }
        return true;
    }
}