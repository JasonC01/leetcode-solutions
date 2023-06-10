class Solution {
    public int maxValue(int n, int index, int maxSum) {
        if (n == 1) {
            return maxSum;
        }
        return binarySearch(maxSum, index, n);
    }

    public boolean checkPossible(int maxSum, int value, int targetIndex, int n) {
        long low = value <= targetIndex + 1 ? 0 : value - targetIndex - 1;
        long remaining = Math.max(targetIndex + 1 - value, 0);
        long sum = ((long) value * (value + 1) / 2) - (low * (low + 1) / 2) + remaining;
        low = value <= n - targetIndex ? 0 : value - n + targetIndex;
        remaining = Math.max(n - targetIndex - value, 0);
        sum += ((long) value * (value + 1) / 2) - (low * (low + 1) / 2) + remaining - value;
        return sum <= maxSum;
    }

    public int binarySearch(int maxSum, int index, int n) {
        int high = maxSum;
        int low = 0;
        while (low < high) {
            int mid = (int) Math.ceil((double) (low + high) / 2);
            if (checkPossible(maxSum, mid, index, n)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}