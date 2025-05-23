class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int min = -1;
        int max = -1;
        long ans = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                start = i + 1;
                min = -1;
                max = -1;
            }
            if (nums[i] == minK) min = i;
            if (nums[i] == maxK) max = i;
            ans += Math.max(0, Math.min(min, max) - start + 1);
        }
        return ans;
    }
}