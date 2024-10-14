class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        for (int i : nums) {
            pq.add(i);
        }
        long ans = 0;
        for (int i = 0; i < k; i++) {
            int curr = pq.poll();
            ans += curr;
            pq.add((int) Math.ceil(curr / 3.0));
        }
        return ans;
    }
}