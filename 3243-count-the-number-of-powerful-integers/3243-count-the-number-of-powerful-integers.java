class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        return helper(finish, limit, s) - helper(start - 1, limit, s);
    }

    public long helper(long num, long limit, String suffix) {
        String numStr = String.valueOf(num);
        int prefixLength = numStr.length() - suffix.length();
        if (prefixLength < 0) return 0;
        long[][] dp = new long[prefixLength + 1][2];
        dp[prefixLength][0] = 1;
        dp[prefixLength][1] = Long.parseLong(numStr.substring(prefixLength)) >= Long.parseLong(suffix) ? 1 : 0;
        for (int i = prefixLength - 1; i >= 0; i--) {
            long numLim = Long.parseLong(numStr.substring(i, i + 1));
            dp[i][0] = (limit + 1) * dp[i + 1][0];

            if (numLim > limit) {
                dp[i][1] = (limit + 1) * dp[i + 1][0];
            } else {
                dp[i][1] = numLim * dp[i + 1][0] + dp[i + 1][1];
            }
        }
        return dp[0][1];
    }
}