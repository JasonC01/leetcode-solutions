class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                counter.merge(nums[i] * nums[j], 1, (a, b) -> a + 1);
            }
        }
        int ans = 0;
        for (int value : counter.values()) {
            if (value > 1) {
                ans += value * (value - 1) * 4;
            }
        }
        return ans;
    }
}