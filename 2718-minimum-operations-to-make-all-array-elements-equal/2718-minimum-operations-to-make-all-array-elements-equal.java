class Solution {
     public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> ans = new ArrayList<>();
        Arrays.sort(nums);
        long[] prefSum = new long[nums.length];
        long[] sufSum = new long[nums.length];
        sufSum[nums.length - 1] = nums[nums.length - 1];
        prefSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefSum[i] = prefSum[i - 1] + nums[i];
            sufSum[nums.length - 1 - i] = sufSum[nums.length - i] + nums[nums.length - 1 - i];
        }
        for (int i : queries) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int mid = (int) Math.ceil((low + high) / 2.0);
                if (nums[mid] <= i) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            long res = 0;
            if (nums[low] <= i) {
                res += ((long) (low + 1) * i) - prefSum[low];
                if (low + 1 < nums.length) {
                    res += sufSum[low + 1] - ((long) (nums.length - 1 - low) * i); 
                }
            } else {
                res = sufSum[0] - ((long) i * nums.length);
            }
            ans.add(res);
        }
        return ans;
    }
}