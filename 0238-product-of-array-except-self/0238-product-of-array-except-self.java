class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pref = new int[nums.length];
        int[] post = new int[nums.length];
        pref[0] = nums[0];
        post[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] * nums[i];
            post[nums.length - 1 - i] = post[nums.length - i] * nums[nums.length - 1 - i];
        }
        int[] ans = new int[nums.length];
        ans[0] = post[1];
        ans[ans.length - 1] = pref[ans.length - 2];
        for (int i = 1; i < nums.length - 1; i++) {
            ans[i] = pref[i - 1] * post[i + 1];
        }
        return ans;
    }
}