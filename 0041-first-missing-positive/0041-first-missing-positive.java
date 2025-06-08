class Solution {
   public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = -1;
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (curr > 0) {
                while (curr > 0) {
                    int newCurr = nums[curr - 1];
                    nums[curr - 1] = 0;
                    curr = newCurr;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) return i + 1;
        }
        return n + 1;
    }
}