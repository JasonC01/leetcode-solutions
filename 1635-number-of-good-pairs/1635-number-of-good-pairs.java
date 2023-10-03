class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int ans = 0;
        for (int i : nums) {
            if (counter.containsKey(i)) {
                ans += counter.get(i);
            }
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        return ans;
    }
}