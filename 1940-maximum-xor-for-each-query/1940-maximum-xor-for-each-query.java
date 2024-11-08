class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] xor = new int[nums.length];
        xor[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor[i] = xor[i - 1] ^ nums[i];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = xor[nums.length - 1 - i] ^ ((int) Math.pow(2, maximumBit) - 1);
        }
        return ans;
    }
}