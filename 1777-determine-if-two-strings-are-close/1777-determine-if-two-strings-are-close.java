class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            map.merge(c, 1, (a, b) -> a + 1);
        }
        for (char c : word2.toCharArray()) {
            map2.merge(c, 1, (a, b) -> a + 1);
        }
        List<Integer> values = new ArrayList<>(map2.values());
        Set<Character> keys = new HashSet<>(map2.keySet());
        for (Integer i : map.values()) {
            values.remove(i);
        }
        for (Character c : map.keySet()) {
            keys.remove(c);
        }
        return values.size() == 0 && keys.size() == 0;
    }
}