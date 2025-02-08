class Solution {
    public String longestPalindrome(String s) {
        boolean[][] memo = new boolean[s.length()][s.length()];
        for (boolean[] i : memo) {
            Arrays.fill(i, false);
        }
        int sAns = 0;
        int eAns = 0;
        for (int i = 0; i < s.length(); i++) {
            memo[i][i] = true;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                sAns = i - 1;
                eAns = i;
                memo[i - 1][i] = true;
            }
        }
        for (int length = 3; length <= s.length(); length++) {
            for (int start = 0; start <= s.length() - length; start++) {
                int end = start + length - 1;
                if (memo[start + 1][end - 1] && s.charAt(start) == s.charAt(end)) {
                    memo[start][end] = true;
                    sAns = start;
                    eAns = end;
                }
            }
        }
        return s.substring(sAns, eAns + 1);
    }
}