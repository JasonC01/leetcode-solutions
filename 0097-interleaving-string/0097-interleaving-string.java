class Solution {
    int[][] memo;
    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new int[s1.length() + 1][s2.length() + 1];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }
        return helper(s1, s2, s3);
    }

    public boolean helper(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (memo[s1.length()][s2.length()] != -1) {
            return memo[s1.length()][s2.length()] == 1;
        }
        boolean ans = false;
        if (s1.isEmpty() && s2.isEmpty()) {
            return s3.isEmpty();
        } else if (s1.isEmpty()) {
            if (s2.charAt(0) == s3.charAt(0)) {
                ans = helper(s1, s2.substring(1), s3.substring(1));
            }
        } else if (s2.isEmpty()) {
            if (s1.charAt(0) == s3.charAt(0)) {
                ans = helper(s1.substring(1), s2, s3.substring(1));
            }
        } else {
            if (s1.charAt(0) == s3.charAt(0)) {
                ans |= helper(s1.substring(1), s2, s3.substring(1));
            }
            if (s2.charAt(0) == s3.charAt(0)) {
                ans |= helper(s1, s2.substring(1), s3.substring(1));
            }
        }
        memo[s1.length()][s2.length()] = ans ? 1 : 0;
        return ans;
    }
}