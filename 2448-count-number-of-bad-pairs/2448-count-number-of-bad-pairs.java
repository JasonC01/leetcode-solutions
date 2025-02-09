class Solution {
    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            counter.merge(i - nums[i], 1, (a, b) -> a + 1);
        }
        long res = 0;
        for (int i : counter.values()) {
            res += comb(i);
        }
        return comb(nums.length) - res;
    }

    public long comb(long n) {
        return n * (n - 1) / 2;
    }

}