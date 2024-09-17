class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> m1 = new HashMap<>();
        for (String s : s1.split(" ")) {
            m1.merge(s, 1, (a, b) -> a + 1);
        }
        for (String s : s2.split(" ")) {
            m1.merge(s, 1, (a, b) -> a + 1);
        }
        List<String> arr = new ArrayList<>();
        for (String s : m1.keySet()) {
            if (m1.get(s) == 1) {
                arr.add(s);
            }
        }
        String[] ans = new String[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}