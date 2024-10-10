class Solution {
   public int maxWidthRamp(int[] nums) {
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty() || stack.peek()[0] < nums[i]) {
                stack.push(new int[]{nums[i], i});
            } else {
                int idx = binarySearch(stack, nums[i]);
                if (idx != -1) {
                    ans = Math.max(ans, idx - i);
                }
            }
        }
        return ans;
    }
    
    public int binarySearch(Stack<int[]> stack, int target) {
        int low = 0;
        int high = stack.size() - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (stack.get(mid)[0] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return stack.get(low)[0] >= target ? stack.get(low)[1] : -1;
    }
}
