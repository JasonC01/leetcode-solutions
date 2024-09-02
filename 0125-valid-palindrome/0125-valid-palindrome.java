class Solution {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        s = s.toLowerCase();
        while (low < high) {
            if (isAlphaNumeric(s.charAt(low)) && isAlphaNumeric(s.charAt(high))) {
                if (s.charAt(low) == s.charAt(high)) {
                    low++;
                    high--;
                } else {
                    return false;
                }
            } else if (!isAlphaNumeric(s.charAt(low))) {
                low++;
            } else if (!isAlphaNumeric(s.charAt(high))) {
                high--;
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(Character c) {
        if (c >= 97 && c <= 122) {
            return true;
        }
        try {
            Integer.parseInt(String.valueOf(c));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}