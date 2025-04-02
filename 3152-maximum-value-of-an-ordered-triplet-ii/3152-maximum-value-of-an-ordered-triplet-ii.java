class Solution {
    public long maximumTripletValue(int[] nums) {
//        int[][] diffArr = new int[nums.length][nums.length];
        long ans = Long.MIN_VALUE;
        int[] maxFromBack = new int[nums.length];
        maxFromBack[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            maxFromBack[i] = Math.max(maxFromBack[i + 1], nums[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int currFront = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                currFront = nums[i];
            }
            stack.push(nums[i]);
            ans = Math.max(ans, (long) (currFront - nums[i]) * maxFromBack[i + 1]);
        }
        return ans;
    }
}