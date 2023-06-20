class Solution {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        if (nums.length < 2 * k + 1) {
            return ans;
        }
        long sum = 0;
        int divisor = 2 * k + 1;
        for (int i = 0; i < 2 * k; i++) {
            sum += nums[i];
        }
        for (int i = k; i < nums.length - k; i++) {
            sum += nums[i + k];
            ans[i] = (int) (sum / divisor);
            sum -= nums[i - k];
        }
        return ans;
    }
}