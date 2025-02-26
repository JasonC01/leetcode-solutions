class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int[] pref = new int[nums.length];
        int[] posSum = new int[nums.length];
        int[] negSum = new int[nums.length];
        pref[0] = nums[0];
        posSum[0] = 0;
        negSum[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            pref[i] = pref[i - 1] + nums[i];
            posSum[i] = Math.max(posSum[i - 1], pref[i - 1]);
            negSum[i] = Math.min(negSum[i - 1], pref[i - 1]);
        }
        // System.out.println(Arrays.toString(pref));
        // System.out.println(Arrays.toString(posSum));
        // System.out.println(Arrays.toString(negSum));
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(ans, Math.abs(pref[i]));
            if (pref[i] > 0) {
                ans = Math.max(ans, Math.abs(pref[i] - negSum[i]));
            } else if (pref[i] < 0) {
                ans = Math.max(ans, Math.abs(pref[i] - posSum[i]));
            } else {
                ans = Math.max(ans, Math.max(posSum[i], Math.abs(negSum[i])));
            }
        }
        return ans;
    }
}



// 1 -2 0 3 -1
// 0  1 1 1  3 max pos sum
// 0  0 -2 -2 -2 max neg sum