class Solution {
    public long countSubarrays(int[] nums, long k) {
        int low = -1;
        int high = 0;
        long ans = 0;
        long currSum = 0;
        while (high <= nums.length) {
            while (high < nums.length && (currSum + nums[high]) * (high - low) >= k) {
                currSum -= nums[++low];
            }
            if (high < nums.length) {
                if ((currSum + nums[high]) * (high - low) < k) ans += (high - low);
                currSum += nums[high];
            }
            
            high++;
        }
        return ans;
    }
}