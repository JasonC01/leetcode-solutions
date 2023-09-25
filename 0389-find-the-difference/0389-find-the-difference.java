class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> counter = new HashMap<>();
        for (char c : s.toCharArray()) {
            counter.merge(c, 1, (a, b) -> a + 1);
        }
        for (char c : t.toCharArray()) {
            counter.merge(c, -1, (a, b) -> a - 1);
        }
        System.out.println(counter);
        for (char c : counter.keySet()) {
            if (counter.get(c) == -1) {
                return c;
            }
        }
        return 'c';
    }
}