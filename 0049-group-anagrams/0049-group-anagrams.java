class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            int[] counter = new int[26];
            for (char c : s.toCharArray()) {
                counter[c - 97]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i : counter) {
                sb.append(i);
                sb.append('.');
            }
            if (!res.containsKey(sb.toString())) {
                res.put(sb.toString(), new ArrayList<>());
            }
            res.get(sb.toString()).add(s);
        }
        return new ArrayList<>(res.values());
    }
}