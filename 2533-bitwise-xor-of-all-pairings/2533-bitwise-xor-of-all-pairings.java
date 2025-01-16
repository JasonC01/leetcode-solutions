class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        boolean isNums1Even = nums1.length % 2 == 0;
        boolean isNums2Even = nums2.length % 2 == 0;
        int ans = 0;
        if (isNums1Even && isNums2Even) {
            return 0;
        } else if (isNums1Even) {
            for (int i : nums1) {
                ans ^= i;
            }
        } else if (isNums2Even) {
            for (int i : nums2) {
                ans ^= i;
            }
        } else {
            for (int i : nums1) {
                ans ^= i;
            }
            for (int i : nums2) {
                ans ^= i;
            }
        }
        return ans;
    }
}