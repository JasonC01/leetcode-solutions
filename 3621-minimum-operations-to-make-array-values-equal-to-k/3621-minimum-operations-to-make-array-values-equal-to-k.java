class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int smallest = Integer.MAX_VALUE;
        for (int i : nums) {
            set.add(i);
            smallest = Math.min(smallest, i);
        }
        return smallest == k ? set.size() - 1 : (k < smallest ? set.size() : -1);
    }
}