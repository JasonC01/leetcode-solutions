class Solution {
    public int maxTwoEvents(int[][] events) {
        int[] max = new int[events.length];
        Arrays.sort(events, Comparator.comparing(x -> x[0]));
        max[max.length - 1] = events[events.length - 1][2];
        for (int i = max.length - 2; i >= 0; i--) {
            max[i] = Math.max(events[i][2], max[i + 1]);
        }
        int ans = 0;
        for (int[] event : events) {
            int idx = bSearch(events, event[1]);
            if (events[idx][0] > event[1]) {
                ans = Math.max(ans, event[2] + max[idx]);
            } else {
                ans = Math.max(ans, event[2]);
            }
        }
        return ans;
    }
    
    public int bSearch(int[][] events, int target) {
        int low = 0;
        int high = events.length - 1;
        while (low < high) {
            int mid = Math.floorDiv(low + high, 2);
            if (events[mid][0] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}