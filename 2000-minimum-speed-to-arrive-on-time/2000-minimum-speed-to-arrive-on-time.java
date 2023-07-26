class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int high = (int) 1e7 + 1;
        int low = 0;
        while (low < high) {
            int mid = (int) Math.floor((double) (low + high) / 2);
            if (isPossible(dist, mid, hour)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low == 1e7 + 1 ? -1 : low;
    }

    public boolean isPossible(int[] dist, int speed, double hour) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        return time + ((double) dist[dist.length - 1] / speed) <= hour;
    }
}