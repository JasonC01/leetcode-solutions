class Solution {
    public int numRabbits(int[] answers) {
        int ans = 0;
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i : answers) {
            counter.merge(i, 1, (a, b) -> a + 1);
        }
        for (int i : counter.keySet()) {
            int count = counter.get(i);
            ans += Math.max(i + 1, (int) Math.ceil((double) count / (i + 1)) * (i + 1));
        }
        return ans;
    }
}