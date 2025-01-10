class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character, Integer> counter = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for (String s : words2) {
            HashMap<Character, Integer> curr = new HashMap<>();
            for (char c : s.toCharArray()) {
                curr.merge(c, 1, (a, b) -> a + 1);
            }
            for (Character key : curr.keySet()) {
                counter.merge(key, curr.get(key), Math::max);
            }
        }
        for (String s : words1) {
            HashMap<Character, Integer> curr = new HashMap<>();
            for (char c : s.toCharArray()) {
                curr.merge(c, 1, (a, b) -> a + 1);
            }
            boolean isUniversal = true;
            for (Character key : counter.keySet()) {
                if (!curr.containsKey(key) || curr.get(key) < counter.get(key)) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.add(s);
            }
        }
        return ans;
    }
}