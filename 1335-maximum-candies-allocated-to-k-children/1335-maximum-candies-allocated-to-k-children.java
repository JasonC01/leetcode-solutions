class Solution {
    public int maximumCandies(int[] candies, long k) {
        long total = 0;
        for (int i : candies) {
            total += i;
        }
        if (total < k) {
            return 0;
        }
        long low = 0;
        long high = total;
        while (low < high) {
            long mid = (long) Math.ceil((low + high) / 2.0);
            if (isPossible(candies, k, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return (int) low;
    }

    public boolean isPossible(int[] candies, long k, long candiesPerPerson) {
        long total = 0;
        for (int i : candies) {
            total += Math.floorDiv(i, candiesPerPerson);
        }
        return total >= k;
    }
}