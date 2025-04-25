class Solution {
    public int subarraySum(int[] nums, int k) {
        int[] pref = new int[nums.length];
        int ans = 0;
        pref[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = nums[i] + pref[i - 1];
        }
        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        for (int i : pref) {
            if (counter.containsKey(i - k)) ans += counter.get(i - k);
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        return ans;
    }
}