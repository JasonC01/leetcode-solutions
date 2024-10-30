class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] dpStart = new int[nums.length];
        int[] dpEnd = new int[nums.length];
        Arrays.fill(dpStart, 1);
        Arrays.fill(dpEnd, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    dpStart[i] = Math.max(dpStart[i], dpStart[j] + 1);
                }
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    dpEnd[i] = Math.max(dpEnd[i], dpEnd[j] + 1);
                }
            }
        }
        System.out.println(Arrays.toString(dpStart));
        System.out.println(Arrays.toString(dpEnd));
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dpStart[i] == 1 || dpEnd[i] == 1) {
                continue;
            }
            ans = Math.max(ans, dpStart[i] + dpEnd[i] - 1);
        }
        return nums.length - ans;
    }
}