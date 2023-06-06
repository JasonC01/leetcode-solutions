class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashSet<Character> first = new HashSet<>();
        HashSet<Character> second = new HashSet<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, (a, b) -> a + 1);
            second.add(c);
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            first.add(curr);
            if (map.get(curr) == 1) {
                second.remove(curr);
            } else {
                map.merge(curr, 0, (a, b) -> a == 0 ? 0 : a - 1);
            }
            if (first.size() == second.size()) {
                ans++;
            }
        }
        return ans;
    }

}