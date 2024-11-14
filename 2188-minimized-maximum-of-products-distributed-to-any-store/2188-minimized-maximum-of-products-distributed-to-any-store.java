class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        long total = 0;
        for (int i : quantities) {
            total += i;
        }
        long low = 1;
        long high = total;
        while (low < high) {
            long mid = Math.floorDiv(low + high, 2);
            if (canDistribute(mid, quantities, n)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    public boolean canDistribute(long n, int[] quantities, int limit) {
        long ans = 0;
        for (int i : quantities) {
            ans += (long) Math.ceil((double) i / n);
        }
        return ans <= limit;
    }
}