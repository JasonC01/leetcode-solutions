class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : nums) {
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        for (int i : counter.values()) {
            if (i % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}