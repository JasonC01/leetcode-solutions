class Solution {
    public int trap(int[] height) {
    int[] pref = new int[height.length];
    int[] suf = new int[height.length];
    pref[0] = height[0];
    suf[height.length - 1] = height[height.length - 1];
    for (int i = 1; i < height.length; i++) {
        pref[i] = Math.max(pref[i - 1], height[i]);
        suf[height.length - 1 - i] = Math.max(suf[height.length - i], height[height.length - 1 - i]);
    }
    int ans = 0;
    for (int i = 0; i < height.length; i++) {
        ans += Math.max(0, Math.min(pref[i], suf[i]) - height[i]);
    }
    return ans;
}
}