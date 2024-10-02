class Solution {
    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{arr[i], i});
        }
        Integer prev = null;
        int rank = 0;
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int[] curr = pq.poll();
            if (prev != null && prev.equals(curr[0])) {
                ans[curr[1]] = rank;
            } else {
                ans[curr[1]] = ++rank;
            }
            prev = curr[0];
        }
        return ans;
    }
}