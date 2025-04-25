class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int[] arr = new int[nums.size()];
        int[] pref = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            arr[i] = nums.get(i) % modulo == k ? 1 : 0;
        }
        pref[0] = arr[0];
        for (int i = 1; i < nums.size(); i++) {
            pref[i] = pref[i - 1] + arr[i];
        }
        long ans = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        counter.put(0, 1);
        for (int i : pref) {
            int modded = (i + modulo - k) % modulo;
            if (counter.containsKey(modded)) ans += counter.get(modded);
            counter.merge(i % modulo, 1, (a, b) -> a + 1);
        }
        return ans;
    }
}