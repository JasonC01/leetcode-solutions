class Solution {
    public int waysToSplitArray(int[] nums) {
        long[] pref = new long[nums.length];
        long[] suf = new long[nums.length];
        pref[0] = nums[0];
        suf[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] + nums[i];
            suf[nums.length - 1 - i] = suf[nums.length - i] + nums[nums.length - 1 - i];
        }
        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (pref[i] >= suf[i + 1]) ans++;
        }
        return ans;
    }
}