class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        HashSet<Integer> set = new HashSet<>(counter.values());
        return set.size() == counter.keySet().size();
    }
}