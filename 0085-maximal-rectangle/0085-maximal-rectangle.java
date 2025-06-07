class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] heights = new int[n][m];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            heights[n - 1][i] = matrix[n - 1][i] == '1' ? 1 : 0;
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                int h = matrix[i][j] == '1' ? 1 : 0;
                heights[i][j] = h == 0 ? 0 : heights[i + 1][j] + h;
            }
        }
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, largestRectangleArea(heights[i]));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> lengths = new Stack<>();
        int ans = 0;
        for (int i : heights) {
            int totalLength = 0;
            int minHeight = Integer.MAX_VALUE;
            while (!stack.isEmpty() && stack.peek() >= i) {
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