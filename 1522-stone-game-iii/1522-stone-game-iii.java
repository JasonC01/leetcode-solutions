class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int total = 0;
        int[][] memo = new int[stoneValue.length + 1][2];
        for (int[] arr : memo) {
            arr[0] = Integer.MIN_VALUE;
            arr[1] = Integer.MAX_VALUE;
        }
        for (int i : stoneValue) total += i;
        memo[stoneValue.length - 1][0] = stoneValue[stoneValue.length - 1];
        memo[stoneValue.length - 1][1] = 0;
        memo[stoneValue.length][0] = 0;
        memo[stoneValue.length][1] = 0;
        for (int i = stoneValue.length - 2; i >= 0; i--) {
            int currScore = 0;
            for (int j = 0; j < 3 && (i + j <= stoneValue.length - 1); j++) {
                currScore += stoneValue[i + j];
                memo[i][0] = Math.max(memo[i][0], memo[i + j + 1][1] + currScore);
                memo[i][1] = Math.min(memo[i][1], memo[i + j + 1][0]);
            }
        }
        return 2 * memo[0][0] > total ? "Alice" : 2 * memo[0][0] < total ? "Bob" : "Tie";
    }
}