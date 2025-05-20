class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int counter = 0;
        int max = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        for (int[] interval : intervals) {
            pq.add(new int[]{interval[0], 1});
            pq.add(new int[]{interval[1], -1});
        }
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currTime = curr[0];
            counter += curr[1];
            while (!pq.isEmpty() && pq.peek()[0] == currTime) {
                counter += pq.poll()[1];
            }
            max = Math.max(max, counter);
        }
        return max;
    }
}