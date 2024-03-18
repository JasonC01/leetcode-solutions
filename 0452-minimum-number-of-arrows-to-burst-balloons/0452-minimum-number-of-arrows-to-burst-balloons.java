class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(x -> x[0]));
        int ans = 0;
        long end = Long.MIN_VALUE;
        for (int[] point : points) {
            int start = point[0];
            int currEnd = point[1];
            if (start <= end) {
                end = Math.min(end, currEnd);
            } else {
                ans++;
                end = currEnd;
            }
        }
        return ans;
    }
}