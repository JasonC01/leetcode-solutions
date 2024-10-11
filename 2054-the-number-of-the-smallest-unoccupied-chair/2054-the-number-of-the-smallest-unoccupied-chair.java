class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<int[]> events = new PriorityQueue<>((a, b) -> a[0] == b[0] ? Integer.compare(a.length, b.length) : Integer.compare(a[0], b[0]));
        for (int i = 0; i < times.length; i++) {
            pq.add(i);
            events.add(new int[]{times[i][0], times[i][1], i});
        }
        while (!events.isEmpty()) {
            int[] curr = events.poll();
            if (curr.length == 3) {
                if (curr[2] == targetFriend) {
                    return pq.poll();
                } else {
                    events.add(new int[]{curr[1], pq.poll()});
                }
            } else {
                pq.add(curr[1]);
            }
        }
        return -1;
    }
}