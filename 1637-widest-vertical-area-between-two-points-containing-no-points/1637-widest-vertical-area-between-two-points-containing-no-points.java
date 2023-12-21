class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<int[]> p = new ArrayList<>(Arrays.asList(points));
        p.sort(Comparator.comparing(x -> x[0]));
        int ans = 0;
        for (int i = 0; i < p.size() - 1; i++) {
            ans = Math.max(ans, p.get(i + 1)[0] - p.get(i)[0]);
        }
        return ans;
    }
}