class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> lengths = new Stack<>();
        int ans = 0;
        for (int i : heights) {
            int totalLength = 0;
            int minHeight = Integer.MAX_VALUE;
            while (!stack.isEmpty() && stack.peek() > i) {
                totalLength += lengths.pop();
                minHeight = Math.min(minHeight, stack.pop());
                ans = Math.max(ans, totalLength * minHeight);
                
            }
           
            stack.push(i);
            lengths.push(totalLength + 1);
        }
        int minHeight = Integer.MAX_VALUE;
        int totalLength = 0;

        while (!lengths.isEmpty()) {
            minHeight = Math.min(minHeight, stack.pop());
            totalLength += lengths.pop();
            ans = Math.max(totalLength * minHeight, ans);
        }
        // ans = Math.max(ans, totalLength * minHeight);
        return ans;
    }
}