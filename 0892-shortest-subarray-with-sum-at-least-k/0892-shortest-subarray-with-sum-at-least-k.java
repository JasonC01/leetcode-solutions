class Solution {
    public int shortestSubarray(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<>();
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            while (!queue.isEmpty() && prefixSum[i] - prefixSum[queue.peekFirst()] >= k) {
                ans = Math.min(ans, i - queue.removeFirst());
            }
            while (!queue.isEmpty() && prefixSum[queue.peekLast()] >= prefixSum[i]) {
                queue.removeLast();
            }
            queue.add(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}


