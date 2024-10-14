class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        List<int[]> res = new ArrayList<>();
        Collections.addAll(pq, intervals);
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int start = curr[0];
            int end = curr[1];
            while (!pq.isEmpty() && pq.peek()[0] <= end) {
                end = Math.max(pq.poll()[1], end);
            }
            res.add(new int[]{start, end});
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}