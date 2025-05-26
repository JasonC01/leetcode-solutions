class Solution {
    int[] memo;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[][] maxValues = new int[n][n];
        for (int i = 0; i < n; i++) {
            maxValues[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                maxValues[i][j] = Math.max(arr[j], maxValues[i][j - 1]);
            }
        }
        memo = new int[n];
        return helper(arr, maxValues, 0, k);
    }

    public int helper(int[] arr, int[][] maxValues, int currIndex, int k) {
        if (currIndex > arr.length - 1) return 0;
        if (memo[currIndex] != 0) return memo[currIndex];
        int ans = 0;
        for (int i = 1; i + currIndex <= arr.length && i <= k; i++) {
            ans = Math.max(ans, helper(arr, maxValues, currIndex + i, k) + (i * maxValues[currIndex][currIndex + i - 1]));
        }
        memo[currIndex] = ans;
        return ans;
    }
}