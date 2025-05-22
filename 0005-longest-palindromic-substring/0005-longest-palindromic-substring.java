class Solution {
    public String longestPalindrome(String s) {
        int low = 0;
        int high = 0;
        for (int i = 0; i < s.length(); i++) {
            int currLength = 0;
            while (i - (currLength + 1) >= 0 && i + (currLength + 1) < s.length() && s.charAt(i - (currLength + 1)) == s.charAt(i + currLength + 1)) {
                currLength++;
            }
            int totalLength = 2 * currLength + 1;
            if (totalLength > high - low) {
                low = i - currLength;
                high = i + currLength + 1;
            }
        }
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                int currLength = 0;
                while (i - (currLength + 1) >= 0 && i + 1 + (currLength + 1) < s.length() && s.charAt(i - (currLength + 1)) == s.charAt(i + 1 + currLength + 1)) {
                    currLength++;
                }
                int totalLength = 2 * currLength + 2;
                if (totalLength > high - low) {
                    low = i - currLength;
                    high = i + currLength + 2;
                }
            }
        }
        return s.substring(low, high);
    }
}