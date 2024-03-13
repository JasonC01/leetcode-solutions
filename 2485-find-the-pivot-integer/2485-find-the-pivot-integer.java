class Solution {
    public int pivotInteger(int n) {
        int[] pSum = new int[n];
        int[] sSum = new int[n];
        pSum[0] = 1;
        sSum[n - 1] = n;
        for (int i = 1; i < n; i++) {
            pSum[i] = pSum[i - 1] + i + 1;
            sSum[n - i - 1] = sSum[n - i] + (n - i);
        }
        for (int i = 0; i < n; i++) {
            if (pSum[i] == sSum[i]) {
                return i + 1;
            }
        }
        return -1;
    }
}