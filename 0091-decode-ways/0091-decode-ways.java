class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[dp.length - 1] = 1;
        dp[dp.length - 2] = s.charAt(s.length() - 1) != '0' ? 1 : 0;
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') continue;
            dp[i] = dp[i + 1] + (Integer.parseInt(s.substring(i, i + 2)) <= 26 ? dp[i + 2] : 0);
        }
        System.out.println(Arrays.toString(dp));
        return dp[0];
    }
}