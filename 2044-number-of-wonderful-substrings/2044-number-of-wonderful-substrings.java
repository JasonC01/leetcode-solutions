class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Integer, Integer> maskCounter = new HashMap<>();
        maskCounter.put(0, 1);
        long ans = 0;
        int currMask = 0;
        for (int i = 0; i < word.length(); i++) {
            currMask ^= 1 << (word.charAt(i) - 'a');
            ans += maskCounter.getOrDefault(currMask, 0);
            maskCounter.merge(currMask, 1, (a, b) -> a + 1);
            for (int j = 0; j <= 10; j++) {
                ans += maskCounter.getOrDefault(currMask ^ (1 << j), 0);
            }
        }
        return ans;
    }
}