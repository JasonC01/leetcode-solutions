class Solution {
    public int countCharacters(String[] words, String chars) {
        int ans = 0;
        for (String s : words) {
            boolean isGood = true;
            String ss = chars;
            for (char c : s.toCharArray()) {
                if (ss.indexOf(c) == -1) {
                    isGood = false;
                    break;
                }
                ss = ss.replaceFirst(String.valueOf(c), "-");
            }
            ans += isGood ? s.length() : 0;
        }
        return ans;
    }
}