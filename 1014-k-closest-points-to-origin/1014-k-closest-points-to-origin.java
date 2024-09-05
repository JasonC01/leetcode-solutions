class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> Math.sqrt(Math.pow(x[0], 2) + Math.pow(x[1], 2))));
        int[][] ans = new int[k][2];
        pq.addAll(Arrays.asList(points));
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }
        return ans;
    }
}