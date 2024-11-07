class Solution {
    public int largestCombination(int[] candidates) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : candidates) {
            int index = 0;
            while (i > 0) {
                int finalI = i;
                counter.merge(index, i % 2, (a, b) -> a + (finalI % 2));
                i = i >> 1;
                index++;
            }
        }
        int ans = 0;
        for (int i : counter.values()) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

}