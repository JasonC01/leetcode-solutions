class Solution {
    public int findLongestChain(int[][] pairs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Collections.addAll(pq, pairs);
        int[] prev = pq.poll();
        int ans = 1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[1] < prev[0]) {
                prev = curr;
                ans++;
            }
        }
        return ans;
    }
}