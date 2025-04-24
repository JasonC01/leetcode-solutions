class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : nums) {
            set.add(i);
        }
        int low = -1;
        int high = 0;
        while (high <= nums.length) {
            if (high < nums.length) counter.merge(nums[high], 1, (a, b) -> a + 1);
            while (counter.size() == set.size()) {
                ans += nums.length - high;
                int currLow = nums[low + 1];
                counter.merge(currLow, 0, (a, b) -> a - 1);
                if (counter.get(currLow) == 0) {
                    counter.remove(currLow);
                }
                low++;
            }
            high++;
        }
        return ans;
    }
}