class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i : nums) {
            pq.add((long) i);
        }
        int ans = 0;
        while (pq.size() >= 2) {
            long first = pq.poll();
            long second = pq.poll();
            if (first >= k) {
                return ans;
            }
            ans++;
            pq.add(2 * Math.min(first, second) + Math.max(first, second));
        }
        return ans;
    }
}