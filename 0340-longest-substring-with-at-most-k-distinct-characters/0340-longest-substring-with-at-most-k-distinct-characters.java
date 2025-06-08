class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int low = -1;
        int high = 0;
        int ans = 0;
        HashMap<Character, Integer> counter = new HashMap<>();
        while (high <= s.length()) {
            while (counter.size() > k) {
                counter.merge(s.charAt(++low), 0, (a, b) -> a - 1);
                if (counter.get(s.charAt(low)) == 0) counter.remove(s.charAt(low));
            }
            ans = Math.max(ans, high - low - 1);
            if (high < s.length()) counter.merge(s.charAt(high), 1, (a, b) -> a + 1);
            high++;
        }
        return ans;
    }
}