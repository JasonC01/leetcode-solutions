class Solution {
     public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            int currWidth = 1;
            if (!stack.isEmpty() && stack.peek()[0] >= currHeight) {
                int[] greatest = stack.pop();
                currWidth += greatest[1];
                while (!stack.isEmpty() && stack.peek()[0] >= currHeight) {
                    int[] curr = stack.pop();
                    currWidth += curr[1];
                    ans = Math.max(ans, curr[0] * (currWidth - 1));
                }
            }
            ans = Math.max(ans, currHeight * currWidth);
            stack.push(new int[]{currHeight, currWidth});
        }
        if (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int width = curr[1];
            while (!stack.isEmpty()) {
                width += stack.peek()[1];
                ans = Math.max(ans, stack.pop()[0] * width);
            }
        }
        return ans;
    }
}