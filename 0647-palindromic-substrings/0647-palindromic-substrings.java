class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans++;
            int low = i - 1;
            int high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                ans++;
            }
            if (i < s.length() - 1 && s.charAt(i) == s.charAt(i + 1)) {
                low = i - 1;
                high = i + 2;
                ans++;
                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                    low--;
                    high++;
                    ans++;
                }
            }
        }
        return ans;
    }
}