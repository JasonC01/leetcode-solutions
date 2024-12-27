class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        pq.add(values[values.length - 1] - (values.length - 1));
        int ans = 0;
        for (int i = values.length - 2; i >= 0; i--) {
            ans = Math.max(ans, pq.peek() + i + values[i]);
            pq.add(values[i] - i);
        }
        return ans;
    }
}