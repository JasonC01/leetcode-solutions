class Solution {
    public int heightChecker(int[] heights) {
        int[] h = Arrays.copyOf(heights, heights.length);
        Arrays.sort(h);
        int ans = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != h[i]) ans++;
        }
        return ans;
    }

}