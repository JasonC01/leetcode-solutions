class Solution {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(x -> x[0]));
        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{Math.min(i, arr[i]), Math.max(i, arr[i])});
        }
        int prev = -1;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] <= prev) {
                prev = Math.max(prev, curr[1]);
            } else {
                ans++;
                prev = curr[1];
            }
        }
        return ans;
    }
}