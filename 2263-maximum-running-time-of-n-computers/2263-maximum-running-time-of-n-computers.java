class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int i : batteries) {
            sum += i;
        }
        long high = sum / n;
        long low = 1;
        while (low < high) {
            long mid = (long) Math.ceil((double) (high + low) / 2);
            long extra = 0;
            for (int i : batteries) {
                extra += Math.min(i, mid);
            }
            if (extra >= ((long) mid * n)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}