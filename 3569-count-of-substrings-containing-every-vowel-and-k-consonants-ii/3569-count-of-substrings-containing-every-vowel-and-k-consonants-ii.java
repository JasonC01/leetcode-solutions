class Solution {
     public long countOfSubstrings(String word, int k) {
        return atLeast(word, k) - atLeast(word, k + 1);
    }

    public long atLeast(String word, int k) {
        HashMap<Character, Integer> vowelCounter = new HashMap<>();
        int consCount = 0;
        int low = -1;
        long ans = 0;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (isVowel(curr)) {
                vowelCounter.merge(curr, 1, (a, b) -> a + 1);
            } else {
                consCount++;
            }
            while (vowelCounter.size() == 5 && consCount >= k) {
                ans += word.length() - i;
                char toBeRemoved = word.charAt(++low);
                if (isVowel(toBeRemoved)) {
                    vowelCounter.merge(toBeRemoved, 0, (a, b) -> a - 1);
                    if (vowelCounter.get(toBeRemoved) == 0) {
                        vowelCounter.remove(toBeRemoved);
                    }
                } else {
                    consCount--;
                }
            }
        }
        return ans;
    }

    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}