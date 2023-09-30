class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min_left = new int[nums.length];

        min_left[0] = Integer.MAX_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < nums.length; i++) {
            min_left[i] = Math.min(min_left[i - 1], nums[i - 1]);
        }
        s.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > min_left[i]) {
                while (!s.isEmpty() && s.peek() <= min_left[i]) {
                    s.pop();
                }
                if (!s.isEmpty() && s.peek() < nums[i]) {
                    return true;
                }
                s.push(nums[i]);
            }
        }
        return false;
    }
}