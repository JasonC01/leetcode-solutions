class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> characters = new HashSet<>();
        if (s.length() <= 1) {
            return s.length();
        }
        characters.add(s.charAt(0));
        int ans = 0;
        int low = 0;
        int high = 1;
        while (high < s.length()) {
            ans = Math.max(ans, high - low);
            char c = s.charAt(high);
            if (characters.contains(c)) {
                while (low < high && characters.contains(c)) {
                    characters.remove(s.charAt(low++));
                }
            }
            characters.add(c);
            high++;
        }
        ans = Math.max(ans, high - low);
        return ans;
    }
}