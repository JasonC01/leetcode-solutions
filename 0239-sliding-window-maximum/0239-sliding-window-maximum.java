class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int i = 0; i < k; i++) {
            pq.add(new int[]{nums[i], i});
        }
        int[] ans = new int[nums.length - k + 1];
        int nextIndex = k;
        ans[0] = pq.peek()[0];
        for (int i = 1; i < ans.length; i++) {
            while (!pq.isEmpty() && pq.peek()[1] <= nextIndex - k) {
                pq.poll();
            }
            pq.add(new int[]{nums[nextIndex], nextIndex});
            nextIndex++;
            ans[i] = pq.peek()[0];
        }
        return ans;
    }
}