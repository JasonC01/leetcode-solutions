class Solution {
    public int[] rearrangeArray(int[] nums) {
        Queue<Integer> pQueue = new ArrayDeque<>();
        Queue<Integer> nQueue = new ArrayDeque<>();
        int[] ans = new int[nums.length];
        boolean isPositive = true;
        for (int i : nums) {
            if (i > 0) {
                pQueue.add(i);
            } else {
                nQueue.add(i);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (isPositive) {
                ans[i] = pQueue.poll();
            } else {
                ans[i] = nQueue.poll();
            }
            isPositive = !isPositive;
        }
        return ans;
    }
}