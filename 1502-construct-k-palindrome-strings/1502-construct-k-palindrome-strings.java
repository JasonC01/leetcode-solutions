class Solution {
    public boolean canConstruct(String s, int k) {
        if (k > s.length()) {
            return false;
        }
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        int oddCount = 0;
        for (int val : counter.values()) {
            if (val % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= k;
    }
}