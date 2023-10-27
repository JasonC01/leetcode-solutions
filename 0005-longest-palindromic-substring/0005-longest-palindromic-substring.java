class Solution {
    public String longestPalindrome(String s) {
        String[][] memo = new String[s.length()][s.length()];
        if (s.length() == 1) {
            return s;
        }
        int currLength = 1;
        int start = 0;
        int end = 0;
        while (currLength <= s.length()) {
            for (int i = 0; i <= s.length() - currLength; i++) {
                if (isPalindrome(s, memo, i, currLength)) {
                    start = i;
                    end = i + currLength;
                    memo[i][i + currLength - 1] = "o";

                }
            }
            currLength++;
        }
        return s.substring(start, end);
    }
    public boolean isPalindrome(String word, String[][] memo, int start, int length) {
        if (length == 1) {
            return true;
        }
        if (length == 2 || memo[start + 1][start + length - 2] != null) {
            return word.charAt(start) == word.charAt(start + length - 1);
        } else {
            return false;
        }
    }
}