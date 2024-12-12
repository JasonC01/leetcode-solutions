class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : gifts) {
            pq.add(i);
        }
        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            pq.add((int) Math.floor(Math.sqrt(curr)));
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }
        return ans;
    }
}