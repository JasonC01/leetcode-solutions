class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        int res = 0;
        for (int val : counter.values()) {
            if (val > 2) {
                res += val % 2 == 1 ? val - 1 : val - 2;
            }
        }
        return s.length() - res;
    }
}