class Solution {
    public int longestSubarray(int[] nums) {
        int maxOne = 0;
        for (int i : nums) {
            maxOne = Math.max(maxOne, i);
        }
        int[] maxAnd = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            maxAnd[i] = nums[i] & maxOne;
        }
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (maxAnd[i - 1] == maxOne && maxAnd[i] == maxOne) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 1;
            }
        }
        int ans = 0;
        for (int i : res) {
            ans = Math.max(i, ans);
        }
        return ans;
    }
}