class Solution {
    int[][] memo;
    public int maxDotProduct(int[] nums1, int[] nums2) {
        memo = new int[nums1.length][nums2.length];
        for (int[] i : memo) {
            Arrays.fill(i, Integer.MIN_VALUE);
        }
        return helper(nums1, nums2, 0, 0, 0, 0);
    }

    public int helper(int[] nums1, int[] nums2, int index1, int index2, int res, int count) {
        if (index1 > nums1.length - 1 || index2 > nums2.length - 1) {
            return count > 0 ? res : Integer.MIN_VALUE;
        }
        if (memo[index1][index2] != Integer.MIN_VALUE) {
            return count > 0 ? Math.max(res, res + memo[index1][index2]) : res + memo[index1][index2];
        }
        int ans = Integer.MIN_VALUE;
        ans = Math.max(helper(nums1, nums2, index1 + 1, index2, res, count), ans);
        ans = Math.max(helper(nums1, nums2, index1, index2 + 1, res, count), ans);
        ans = Math.max(helper(nums1, nums2, index1 + 1, index2 + 1, res + (nums1[index1] * nums2[index2]), count + 1), ans);
        return memo[index1][index2] = ans - res;
    }
}