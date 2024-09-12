class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            set.add(c);
        }
        int ans = 0;
        for (String s : words) {
            boolean pass = true;
            for (char c : s.toCharArray()) {
                if (!set.contains(c)) {
                    pass = false;
                    break;
                }
            }
            if (pass) ans++;
        }
        return ans;
    }
}