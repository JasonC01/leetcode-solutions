class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int steps = (nums[i] - 1) / last;
            ans += steps;
            last = nums[i] / (steps + 1);
        }
        return ans;
    }

}