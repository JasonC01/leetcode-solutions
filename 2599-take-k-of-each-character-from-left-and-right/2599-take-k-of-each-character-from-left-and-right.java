class Solution {
    public int takeCharacters(String s, int k) {
        HashMap<Character, Integer> counter = new HashMap<>();
        if (k == 0) {
            return 0;
        }
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        if (counter.keySet().size() < 3) {
            return -1;
        }
        for (char c : counter.keySet()) {
            if (counter.get(c) < k) {
                return -1;
            }
        }
        int ans = s.length();
        int low = -1;
        for (int high = 0; high < s.length(); high++) {
            counter.merge(s.charAt(high), 0, (a, b) -> a - 1);
            if (counter.get(s.charAt(high)) >= k) {
                ans = Math.min(ans, s.length() - (high - low));
            } else {
                while (counter.get(s.charAt(high)) < k) {
                    counter.merge(s.charAt(++low), 1, (a, b) -> a + 1);
                }
            }
        }
        // ans = Math.min(ans, low);
        return ans;
    }
}