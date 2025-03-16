class Solution {
    public long repairCars(int[] ranks, int cars) {
        long low = 0;
        long high = (long) 1e14;
        while (low < high) {
            long mid = Math.floorDiv(low + high, 2);
            if (isPossible(ranks, mid, cars)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public boolean isPossible(int[] ranks, long time, int cars) {
        long repaired = 0;
        for (int i : ranks) {
            repaired += (long) Math.floor(Math.sqrt((double) time / i));
        }
        return repaired >= cars;
    }
}