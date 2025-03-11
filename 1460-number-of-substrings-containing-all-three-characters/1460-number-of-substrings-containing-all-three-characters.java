class Solution {
    public int numberOfSubstrings(String word) {
        HashMap<Character, Integer> vowelCounter = new HashMap<>();
        int low = -1;
        int ans = 0;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            if (isabc(curr)) {
                vowelCounter.merge(curr, 1, (a, b) -> a + 1);
            }
            while (vowelCounter.size() == 3) {
                ans += word.length() - i;
                char toBeRemoved = word.charAt(++low);
                if (isabc(toBeRemoved)) {
                    vowelCounter.merge(toBeRemoved, 0, (a, b) -> a - 1);
                    if (vowelCounter.get(toBeRemoved) == 0) {
                        vowelCounter.remove(toBeRemoved);
                    }
                }
            }
        }
        return ans;
    }
    public boolean isabc(char c) {
        return c == 'a' || c == 'b' || c == 'c';
    }
}