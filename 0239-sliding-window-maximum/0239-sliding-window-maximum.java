class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> counter = new TreeMap<>((a, b) -> Integer.compare(b, a));
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            counter.merge(nums[i], 1, (a, b) -> a + 1);
        }
        ans[0] = counter.firstKey();
        for (int i = k; i < nums.length; i++) {
            counter.merge(nums[i - k], 0, (a, b) -> a - 1);
            if (counter.get(nums[i - k]) == 0) counter.remove(nums[i - k]);
            counter.merge(nums[i], 1, (a, b) -> a + 1);
            ans[i - k + 1] = counter.firstKey();
        }
        return ans;
    }
}