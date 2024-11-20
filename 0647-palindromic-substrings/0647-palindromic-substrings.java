class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length() + 1][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (i == 0) {
                    dp[i][j] = isPalindrome(s.substring(i, j + 1));
                } else {
                    if (j - i < 2) {
                        dp[i][j] = s.charAt(i) == s.charAt(j);
                    } else {
                        dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1];
                    }
                }
            }
        }
        int ans = 0;
        for (boolean[] i : dp) {
            for (boolean j : i) {
                if (j) ans++;
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}