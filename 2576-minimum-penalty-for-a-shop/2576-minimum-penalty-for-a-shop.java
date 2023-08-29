class Solution {
    public int bestClosingTime(String customers) {
        int[] cumulativeSum = new int[customers.length() + 2];
        for (int i = 1; i < cumulativeSum.length - 1; i++) {
            cumulativeSum[i] = cumulativeSum[i - 1] + (customers.charAt(i - 1) == 'Y' ? 1 : -1);
        }
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int maxPenalty = cumulativeSum[cumulativeSum.length - 1];
        for (int i = 1; i < cumulativeSum.length; i++) {
            if (maxPenalty - cumulativeSum[i - 1] < min) {
                ans = i;
                min = maxPenalty - cumulativeSum[i - 1];
            }
        }
        return ans - 1;
    }
}