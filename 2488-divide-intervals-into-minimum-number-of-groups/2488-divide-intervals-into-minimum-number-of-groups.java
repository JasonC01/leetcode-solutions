class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        int ans = 0;
        int curr = 0;
        for (int[] interval : intervals) {
            pq.add(new int[]{interval[0], 1});
            pq.add(new int[]{interval[1], -1});
        }
        while (!pq.isEmpty()) {
            curr += pq.poll()[1];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}