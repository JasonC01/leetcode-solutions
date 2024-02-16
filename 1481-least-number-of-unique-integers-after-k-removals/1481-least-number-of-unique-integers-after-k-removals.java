class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : arr) {
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        List<Integer> c = new ArrayList<>(counter.values());
        c.sort(Comparator.comparing(x -> x));
        int removed = 0;
        for (int i = 0; i < c.size(); i++) {
            int curr = c.get(i);
            if (k >= curr) {
                removed++;
                k -= curr;
            } else {
                return c.size() - i;
            }
        }
        return c.size() - removed;
    }
}