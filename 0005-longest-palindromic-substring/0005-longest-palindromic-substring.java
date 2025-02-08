class Solution {
    public String longestPalindrome(String s) {
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int left = i - 1; 
            int right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > maxRight - maxLeft - 1) {
                maxLeft = left;
                maxRight = right;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                continue;
            }
            int left = i - 1;
            int right = i + 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if (right - left - 1 > maxRight - maxLeft - 1) {
                maxLeft = left;
                maxRight = right;
            }
        }
        return s.substring(maxLeft + 1, maxRight);
    }
}