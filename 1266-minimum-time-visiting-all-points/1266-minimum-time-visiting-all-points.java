class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i = 0; i < points.length - 1; i++) {
            int[] curr = points[i];
            int[] next = points[i + 1];
            int xDiff = Math.abs(curr[0] - next[0]);
            int yDiff = Math.abs(curr[1] - next[1]);
            int larger = Math.max(xDiff, yDiff);
            ans += larger;
        }
        return ans;
    }
}