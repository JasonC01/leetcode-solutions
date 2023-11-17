class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            ans = Math.max(ans, nums[low++] + nums[high--]);
        }
        return ans;
    }
}