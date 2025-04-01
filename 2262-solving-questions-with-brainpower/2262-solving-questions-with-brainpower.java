class Solution {
    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length + 1];
        int n = questions.length;
        for (int i = questions.length - 1; i >= 0; i--) {
            memo[i] = Math.max(memo[i + 1], questions[i][0] + memo[Math.min(i + questions[i][1] + 1, n)]);
        }
        return memo[0];
    }
}