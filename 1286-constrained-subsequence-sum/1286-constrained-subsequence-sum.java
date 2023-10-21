class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int[] memo = new int[nums.length];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && i - dq.peek() > k) {
                dq.pollFirst();
            }
            int maxVal = Math.max(0, dq.isEmpty() ? 0 : memo[dq.peek()]);
            memo[i] = nums[i] + maxVal;
            while (!dq.isEmpty() && memo[dq.peekLast()] < memo[i]) {
                dq.pollLast();
            }
            if (memo[i] > 0) {
                dq.offer(i);
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i : memo) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

}