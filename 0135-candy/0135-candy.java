class Solution {
    public int candy(int[] ratings) {
        int[] peakValues = new int[ratings.length];
        Arrays.fill(peakValues, 1);
        for (int i = 1; i < peakValues.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                peakValues[i] = peakValues[i - 1] + 1;
            }
        }
        for (int i = peakValues.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                peakValues[i] = Math.max(peakValues[i + 1] + 1, peakValues[i]);
            }
        }
        int ans = 0;
        for (int i : peakValues) {
            ans += i;

        }
        return ans;
    }
}