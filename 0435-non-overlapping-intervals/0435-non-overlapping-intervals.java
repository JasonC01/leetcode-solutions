class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        Collections.addAll(pq, intervals);
        int lastStart = Integer.MAX_VALUE;
        int count = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int end = curr[1];
            int start = curr[0];
            if (end <= lastStart) {
                lastStart = start;
                count++;
            }
        }
        return intervals.length - count;
    }
}