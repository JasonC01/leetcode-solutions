class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long total = 0;
        for (int i : piles) {
            total += i;
        }
        long low = 1;
        long high = total;
        while (low < high) {
            long mid = Math.floorDiv(low + high, 2);
            if (canEat(mid, piles, h)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return (int) low;
    }

    public boolean canEat(long speed, int[] piles, int limit) {
        long ans = 0;
        for (int i : piles) {
            ans += (long) Math.ceil((double) i / speed);
        }
        return ans <= limit;
    }
}