class Solution {
    public int heightChecker(int[] heights) {
        int[][] h = new int[heights.length][2];
        for (int i = 0; i < heights.length; i++) {
            h[i] = new int[]{heights[i], i};
        }
        for (int i = h.length - 1; i >= 0; i--) {
            int curr = i;
            while (curr < h.length - 1 && h[curr + 1][0] < h[curr][0]) {
                int[] temp = h[curr];
                h[curr] = h[curr + 1];
                h[curr + 1] = temp;
                curr++;
            }
        }
        int ans = 0;
        for (int i = 0; i < h.length; i++) {
            if (h[i][1] != i && h[i][0] != heights[i]) {
                ans++;
            }
        }
        return ans;
    }
}