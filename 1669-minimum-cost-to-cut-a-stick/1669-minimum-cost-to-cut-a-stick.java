class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[][] pieces = new int[cuts.length + 1][2];
        pieces[0] = new int[]{0, cuts[0]};
        pieces[cuts.length] = new int[]{cuts[cuts.length - 1], n};
        for (int i = 1; i < cuts.length; i++) {
            pieces[i] = new int[]{cuts[i - 1], cuts[i]};
        }
        // System.out.prinln(Arrays.deepToString(pieces));
        int[][] dp = new int[pieces.length][pieces.length];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 0;
        }
        for (int length = 2; length <= pieces.length; length++) {
            for (int start = 0; start <= pieces.length - length; start++) {
                int end = start + length - 1;
                int startLength = pieces[start][0];
                int endLength = pieces[end][1];
                int totalLength = endLength - startLength;
                for (int k = start; k < end; k++) {
                    dp[start][end] = Math.min(dp[start][k] + dp[k + 1][end] + totalLength, dp[start][end]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[0][pieces.length - 1];
    }
}