class Solution {
    public long countGood(int[] nums, int k) {
        long ans = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        int low = -1;
        long currCount = 0;
        for (int i = 0; i < nums.length; i++) {
            currCount += counter.getOrDefault(nums[i], 0);
            counter.merge(nums[i], 1, (a ,b) -> a + 1);
            while (low < i && currCount >= k) {
                ans += (nums.length - i);
                currCount -= counter.get(nums[low + 1]) - 1;
                counter.merge(nums[low + 1], 0, (a, b) -> a - 1);
                low++;
            }
        }
        while (low < nums.length && currCount >= k) {
            ans++;
            currCount -= counter.get(nums[low + 1]) - 1;
            counter.merge(nums[low + 1], 0, (a, b) -> a - 1);
            low++;
        }
        return ans;
    }
}