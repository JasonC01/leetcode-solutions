class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            counter.merge(nums[i], 1, (a, b) -> a + 1);
        }
        for (int i = k; i < nums.length; i++) {
            if (counter.keySet().size() == k) {
                ans = Math.max(ans, sum);
            }
            counter.merge(nums[i - k], 0, (a, b) -> a - 1);
            sum -= nums[i - k];
            if (counter.get(nums[i - k]) == 0) {
                counter.remove(nums[i - k]);
            }
            counter.merge(nums[i], 1, (a, b) -> a + 1);
            sum += nums[i];
        }
        if (counter.keySet().size() == k) {
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}