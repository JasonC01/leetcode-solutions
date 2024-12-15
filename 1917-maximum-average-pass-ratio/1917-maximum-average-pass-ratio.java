class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare(computeDiff(b), computeDiff(a)));
        pq.addAll(Arrays.asList(classes));
        for (int i = 0; i < extraStudents; i++) {
            int[] curr = pq.poll();
            curr[0]++;
            curr[1]++;
            pq.add(curr);
        }
        double ans = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            ans += ((double) curr[0] / curr[1]);
        }
        return ans / classes.length;
    }
    
    public double computeDiff(int[] x) {
        return ((double) (x[0] + 1) / (x[1] + 1)) -  ((double) x[0] / x[1]);
    }
}