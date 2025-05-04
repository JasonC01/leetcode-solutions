class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int ans = 0;
        HashMap<Integer, HashMap<Integer, Integer>> counter = new HashMap<>();
        for (int[] domino : dominoes) {
            int first = domino[0];
            int second = domino[1];
            if (!counter.containsKey(first)) counter.put(first, new HashMap<>());
            if (!counter.containsKey(second)) counter.put(second, new HashMap<>());
            if (counter.get(first).containsKey(second) || counter.get(second).containsKey(first)) ans += counter.get(first).get(second);
            counter.get(first).merge(second, 1, (a, b) -> a + 1);
            if (first != second) counter.get(second).merge(first, 1, (a, b) -> a + 1);
        }
        return ans;
    }
}