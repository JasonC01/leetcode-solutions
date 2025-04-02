class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = Long.MIN_VALUE;
        int[] maxFromBack = new int[nums.length];
        maxFromBack[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxFromBack[i] = Math.max(maxFromBack[i + 1], nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                ans = Math.max(ans, (long) (nums[i] - nums[j]) * maxFromBack[j + 1]);
            }
        }
        return Math.max(ans, 0);
    }
}