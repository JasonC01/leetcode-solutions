class Solution {
    public boolean buddyStrings(String s, String goal) {
        int diffCount = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                diffCount++;
            }
            map.merge(s.charAt(i), 1, (a, b) -> a + 1);
        }
        boolean ans = diffCount == 2;
        for (Character i : map.keySet()) {
            if (map.get(i) > 1 && diffCount == 0) {
                ans = true;
            }
        }
        for (Character c : goal.toCharArray()) {
            map.merge(c, 1, (a, b) -> a - 1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c) > 0) {
                return false;
            }
        }
        return ans;
    }
}