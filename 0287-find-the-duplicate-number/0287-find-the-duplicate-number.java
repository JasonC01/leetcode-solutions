class Solution {
    public int findDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, (a, b) -> a + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) > 1) {
                return i;
            }
        }
        return -1;
    }
}